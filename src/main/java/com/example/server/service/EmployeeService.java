package com.example.server.service;

import com.example.server.dto.response.EmployeeResponse;
import com.example.server.entities.NhanVien;
import com.example.server.entities.UserRole;
import com.example.server.repositories.NhanVienRepository;
import com.example.server.repositories.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<EmployeeResponse> getAllEmployees() {

        List<NhanVien> danhSachNhanVien = nhanVienRepository.findAll();

        return danhSachNhanVien.stream()
                .map(nhanVien -> {

                    String roleName = userRoleRepository
                            .findByUser_UserID(nhanVien.getUserID())
                            .stream()
                            .findFirst()
                            .map(r -> r.getRole().getRoleName())
                            .orElse("NO_ROLE");

                    return new EmployeeResponse(
                            nhanVien.getUserID(),
                            nhanVien.getUser().getHoTen(),
                            nhanVien.getUser().getEmail(),
                            nhanVien.getUser().getPassword(),
                            roleName,
                            nhanVien.getUser().getNgayTao(),
                            nhanVien.getChucVu(),
                            nhanVien.getLuongCoBan(),
                            nhanVien.getLuongPhuCap()
                    );
                })
                .toList();
    }

}
