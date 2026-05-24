package com.example.server.service;

import com.example.server.dto.response.ApplicationResponse;
import com.example.server.entities.*;
import com.example.server.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private HSDangKyMentorRepository hsDangKyMentorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ApplicationResponse> getApplication(Integer trangThai) {
        List<HSDangKyMentor> danhSachHoSo = hsDangKyMentorRepository.findByTrangThai(trangThai);
        return danhSachHoSo.stream().map(
                hs -> new ApplicationResponse(
                        hs.getHocVien().getUserID(),
                        hs.getHocVien().getUser().getHoTen(),
                        hs.getHocVien().getUser().getEmail(),
                        hs.getHoSoID(),
                        hs.getNgayTao(),
                        hs.getUrl(),
                        hs.getTrangThai()
                )
        ).toList();
    }

    @Transactional
    public void approveApplication(String hoSoID) {
        HSDangKyMentor hsDangKyMentor = hsDangKyMentorRepository.findById(hoSoID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (hsDangKyMentor.getTrangThai() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        hsDangKyMentor.setTrangThai(1);
    }

    @Transactional
    public void rejectApplication(String hoSoID) {
        HSDangKyMentor hsDangKyMentor = hsDangKyMentorRepository.findById(hoSoID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (hsDangKyMentor.getTrangThai() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        hsDangKyMentor.setTrangThai(3);
    }

    @Transactional
    public void grantMentor(String hoSoID) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("proc_grant_mentor");

        query.registerStoredProcedureParameter("p_hoso_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_status_code", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_message", String.class, ParameterMode.OUT);

        query.setParameter("p_hoso_id", hoSoID);

        query.execute();

        Integer statusCode = (Integer) query.getOutputParameterValue("p_status_code");
        String message = (String) query.getOutputParameterValue("p_message");

        if (statusCode != 200) {
            if (statusCode == -20001 || statusCode == -20003) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
            } else if (statusCode == -20002) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, message);
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database Error: " + message);
            }
        }
    }

}
