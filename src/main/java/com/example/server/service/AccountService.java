package com.example.server.service;

import com.example.server.dto.request.ChangePasswordRequest;
import com.example.server.dto.request.UpdateLearnerProfileRequest;
import com.example.server.dto.request.UpdateMentorProfileRequest;
import com.example.server.dto.response.EmployeeProfileResponse;
import com.example.server.dto.response.LearnerProfileResponse;
import com.example.server.dto.response.MentorProfileResponse;
import com.example.server.entities.HocVien;
import com.example.server.entities.NguoiHuongDan;
import com.example.server.entities.NhanVien;
import com.example.server.entities.Users;
import com.example.server.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    @Autowired
    private UserRepository userRepository;

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

    @Transactional
    public ResponseEntity<?> changePassword(ChangePasswordRequest request) {
        //get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find user
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        // check password
        if (!user.getPassword().equals(request.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password doesn't match!");
        }
        // change password
        user.setPassword(request.getNew_password());

        return ResponseEntity.ok().body("Successfully changed password!");
    }

    @Transactional
    public ResponseEntity<?> changeLearnerProfile(UpdateLearnerProfileRequest request) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find hoc vien
        HocVien hocVien = hocVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        // check hoTen;
        if (!hocVien.getUser().getHoTen().equals(request.getHoTen())) {
            hocVien.getUser().setHoTen(request.getHoTen());
        }
        // check email
        if (!hocVien.getUser().getEmail().equals(request.getEmail())) {
            hocVien.getUser().setEmail(request.getEmail());
        }
        // check gpa
        if (!Objects.equals(hocVien.getGpa(), request.getGpa())) {
            hocVien.setGpa(request.getGpa());
        }
        // check quocGiaDuHoc
        if (!Objects.equals(hocVien.getQuocGiaDuHoc(), request.getQuocGiaDuHoc())) {
            hocVien.setQuocGiaDuHoc(request.getQuocGiaDuHoc());
        }
        // check nganhHoc
        if (!Objects.equals(hocVien.getNganhHoc(), request.getNganhHoc())) {
            hocVien.setNganhHoc(request.getNganhHoc());
        }

        return ResponseEntity.ok().body("Successfully changed profile!");
    }

    @Transactional
    public ResponseEntity<?> changeMentorProfile(UpdateMentorProfileRequest request) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find hoc vien
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // check hoTen;
        if (!user.getHoTen().equals(request.getHoTen())) {
            user.setHoTen(request.getHoTen());
        }
        // check email
        if (!user.getEmail().equals(request.getEmail())) {
            user.setEmail(request.getEmail());
        }

        return ResponseEntity.ok().body("Successfully changed profile!");
    }
}
