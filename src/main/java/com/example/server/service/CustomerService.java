package com.example.server.service;

import com.example.server.dto.response.CustomerResponse;
import com.example.server.entities.UserRole;
import com.example.server.entities.Users;
import com.example.server.repositories.HocVienRepository;
import com.example.server.repositories.NguoiHuongDanRepository;
import com.example.server.repositories.UserRepository;
import com.example.server.repositories.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<CustomerResponse> getCustomersByTrangThai(Integer trangThai) {
        List<Users> users = userRepository.findByTrangThaiWithRoles(trangThai);

        return users.stream().map(user -> {
                    if (user.getNguoiHuongDan() != null) {
                        return new CustomerResponse(
                                user.getUserID(),
                                user.getHoTen(),
                                user.getEmail(),
                                user.getNgayTao(),
                                "Người hướng dẫn",
                                user.getTrangThai(),
                                user.getNguoiHuongDan().getDoanhThu(),
                                user.getNguoiHuongDan().getTrungBinhDanhGia()
                        );
                    }

                    if (user.getHocVien() != null) {
                        return new CustomerResponse(
                                user.getUserID(),
                                user.getHoTen(),
                                user.getEmail(),
                                user.getNgayTao(),
                                "Học viên",
                                user.getTrangThai(),
                                user.getHocVien().getQuocGiaDuHoc(),
                                user.getHocVien().getGpa(),
                                user.getHocVien().getNganhHoc()
                        );
                    }

                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Transactional
    public void banCustomer(String userID) {
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (user.getTrangThai() == 1) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        user.setTrangThai(1);
    }
    @Transactional
    public void unbanCustomer(String userID) {
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (user.getTrangThai() == 2) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        user.setTrangThai(2);
    }

}
