package com.example.server.service;

import com.example.server.dto.response.EmployeeProfileResponse;
import com.example.server.dto.response.LearnerProfileResponse;
import com.example.server.dto.response.MentorProfileResponse;
import com.example.server.entities.HocVien;
import com.example.server.entities.NguoiHuongDan;
import com.example.server.entities.NhanVien;
import com.example.server.repositories.HocVienRepository;
import com.example.server.repositories.NguoiHuongDanRepository;
import com.example.server.repositories.NhanVienRepository;
import com.example.server.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountService {

    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public LearnerProfileResponse getLearnerProfile() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        HocVien hocVien = hocVienRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học viên"));

        return new LearnerProfileResponse(
                hocVien.getUserID(),
                hocVien.getUser().getHoTen(),
                hocVien.getUser().getEmail(),
                hocVien.getGpa(),
                hocVien.getQuocGiaDuHoc(),
                hocVien.getNganhHoc(),
                hocVien.getUser().getNgayTao()
        );
    }

    public MentorProfileResponse getMentorProfile() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        NguoiHuongDan nguoiHuongDan = nguoiHuongDanRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người hướng dẫn!"));

        return new MentorProfileResponse(
                nguoiHuongDan.getUserID(),
                nguoiHuongDan.getUser().getHoTen(),
                nguoiHuongDan.getUser().getEmail(),
                nguoiHuongDan.getTrungBinhDanhGia(),
                nguoiHuongDan.getDoanhThu(),
                nguoiHuongDan.getUser().getNgayTao()
        );
    }

    public EmployeeProfileResponse getEmployeeProfile() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhân viên!"));

        return new EmployeeProfileResponse(
                nhanVien.getUserID(),
                nhanVien.getUser().getHoTen(),
                nhanVien.getUser().getEmail(),
                nhanVien.getChucVu(),
                nhanVien.getLuongCoBan(),
                nhanVien.getLuongPhuCap(),
                nhanVien.getUser().getNgayTao()
        );
    }

}
