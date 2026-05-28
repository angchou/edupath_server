package com.example.server.service;

import com.example.server.dto.request.CreateEmployeeRequest;
import com.example.server.dto.request.CreatePayrollRequest;
import com.example.server.dto.request.UpdateEmployeeRequest;
import com.example.server.dto.response.EmployeeResponse;
import com.example.server.dto.response.PayrollResponse;
import com.example.server.entities.*;
import com.example.server.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LuongChiTietRepository luongChiTietRepository;
    @Autowired
    private LoaiNganSachRepository loaiNganSachRepository;

    public List<EmployeeResponse> getAllEmployees() {

        List<NhanVien> danhSachNhanVien = nhanVienRepository.findByRoleIdNot("6");

        return danhSachNhanVien.stream()
                .map(nhanVien -> {

                    Integer roleID = userRoleRepository
                            .findByUser_UserID(nhanVien.getUserID())
                            .stream()
                            .findFirst()
                            .map(r -> r.getRole().getRoleID())
                            .orElse(0);

                    return new EmployeeResponse(
                            nhanVien.getUserID(),
                            nhanVien.getUser().getHoTen(),
                            nhanVien.getUser().getEmail(),
                            nhanVien.getUser().getPassword(),
                            roleID,
                            nhanVien.getUser().getNgayTao(),
                            nhanVien.getUser().getTrangThai(),
                            nhanVien.getChucVu(),
                            nhanVien.getLuongCoBan(),
                            nhanVien.getLuongPhuCap()
                    );
                })
                .toList();
    }

    public List<EmployeeResponse> getEmployeesInfoForPayroll() {
        List<NhanVien> danhSachNhanVien = nhanVienRepository.findByUser_TrangThai(2);

        return danhSachNhanVien.stream()
                .map(nhanVien -> {

                    Integer roleID = userRoleRepository
                            .findByUser_UserID(nhanVien.getUserID())
                            .stream()
                            .findFirst()
                            .map(r -> r.getRole().getRoleID())
                            .orElse(0);

                    LocalDate ngayTraLuongCuoiCung = luongChiTietRepository.findLatestNgayTaoByUserId(nhanVien.getUserID());

                    return new EmployeeResponse(
                            nhanVien.getUserID(),
                            nhanVien.getUser().getHoTen(),
                            nhanVien.getUser().getEmail(),
                            nhanVien.getUser().getPassword(),
                            roleID,
                            nhanVien.getUser().getNgayTao(),
                            nhanVien.getUser().getTrangThai(),
                            nhanVien.getChucVu(),
                            nhanVien.getLuongCoBan(),
                            nhanVien.getLuongPhuCap(),
                            ngayTraLuongCuoiCung
                    );
                })
                .toList();
    }

    public List<PayrollResponse> getEmployeePayroll(String userID) {
        List<LuongChiTiet> danhSachLuong = luongChiTietRepository.findByNhanVien_UserID(userID);

        return danhSachLuong.stream().map(
                luong -> new PayrollResponse(
                        luong.getLuongChiTietID(),
                        luong.getLuongThuong(),
                        luong.getLuongKhauTru(),
                        luong.getLuongCuoiCung(),
                        luong.getTrangThai(),
                        luong.getNgayTao()
                )
        ).toList();
    }

    public List<EmployeeResponse> getActiveEmployees() {
        List<NhanVien> danhSachNhanVien = nhanVienRepository.findByRoleIdNotAndTrangThai("6", 2);

        return danhSachNhanVien.stream()
                .map(nhanVien -> {

                    Integer roleID = userRoleRepository
                            .findByUser_UserID(nhanVien.getUserID())
                            .stream()
                            .findFirst()
                            .map(r -> r.getRole().getRoleID())
                            .orElse(0);

                    return new EmployeeResponse(
                            nhanVien.getUserID(),
                            nhanVien.getUser().getHoTen(),
                            nhanVien.getUser().getEmail(),
                            nhanVien.getUser().getPassword(),
                            roleID,
                            nhanVien.getUser().getNgayTao(),
                            nhanVien.getUser().getTrangThai(),
                            nhanVien.getChucVu(),
                            nhanVien.getLuongCoBan(),
                            nhanVien.getLuongPhuCap()
                    );
                })
                .toList();
    }

    public List<EmployeeResponse> getNewEmployees() {

        List<NhanVien> danhSachNhanVien = nhanVienRepository.findByUser_NgayTao(LocalDate.now());

        return danhSachNhanVien.stream()
                .map(nhanVien -> {

                    Integer roleID = userRoleRepository
                            .findByUser_UserID(nhanVien.getUserID())
                            .stream()
                            .findFirst()
                            .map(r -> r.getRole().getRoleID())
                            .orElse(0);

                    return new EmployeeResponse(
                            nhanVien.getUserID(),
                            nhanVien.getUser().getHoTen(),
                            nhanVien.getUser().getEmail(),
                            nhanVien.getUser().getPassword(),
                            roleID,
                            nhanVien.getUser().getNgayTao(),
                            nhanVien.getUser().getTrangThai(),
                            nhanVien.getChucVu(),
                            nhanVien.getLuongCoBan(),
                            nhanVien.getLuongPhuCap()
                    );
                })
                .toList();
    }

    @Transactional
    public ResponseEntity<?> createEmployee(CreateEmployeeRequest request) {
        // create new user
        Users user = new Users();
        user.setHoTen(request.getHoTen());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setTrangThai(2);
        user.setNgayTao(LocalDate.now());
        userRepository.save(user);

        // create new employee
        NhanVien nhanVien = new NhanVien();
        nhanVien.setUser(user);
        nhanVien.setChucVu(request.getChucVu());
        nhanVien.setLuongCoBan(request.getLuongCoBan());
        nhanVien.setLuongPhuCap(request.getLuongPhuCap());
        nhanVienRepository.save(nhanVien);

        // find role
        Role role = roleRepository.findById(request.getRoleID())
                .orElseThrow(() -> new RuntimeException("Role not found!"));

        // create user role
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        return ResponseEntity.ok().body("Successfully created employee!");
    }

    @Transactional
    public void createPayroll(CreatePayrollRequest request) {
        NhanVien nhanVien = nhanVienRepository.findById(request.getUserID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (nhanVien.getUser().getTrangThai() != 2) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        LuongChiTiet luongChiTiet = new LuongChiTiet();
        luongChiTiet.setNhanVien(nhanVien);
        luongChiTiet.setLuongThuong(request.getLuongThuong());
        luongChiTiet.setLuongKhauTru(request.getLuongKhauTru());

        BigDecimal luongCuoiCung = nhanVien.getLuongCoBan().add(nhanVien.getLuongPhuCap()).add(request.getLuongThuong()).subtract(request.getLuongKhauTru());
        luongChiTiet.setLuongCuoiCung(luongCuoiCung);

        LoaiNganSach loaiNganSach = loaiNganSachRepository.findById("LNS000001")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        luongChiTiet.setLoaiNganSach(loaiNganSach);
        luongChiTiet.setTrangThai(0);
        luongChiTiet.setNgayTao(LocalDate.now());

        luongChiTietRepository.save(luongChiTiet);
    }

    @Transactional
    public ResponseEntity<?> deleteEmployee(String nhanVienID) {
        // find nhan vien
        NhanVien nhanVien = nhanVienRepository.findById(nhanVienID)
                .orElseThrow(() -> new RuntimeException("Employee not found!"));

        // change status to 3 : no longer working
        nhanVien.getUser().setTrangThai(3);

        return ResponseEntity.ok().body("Employee " + nhanVienID + " is no longer working!");
    }

    @Transactional
    public ResponseEntity<?> updateEmployee(UpdateEmployeeRequest request) {
        // find nhan vien
        NhanVien nhanVien = nhanVienRepository.findById(request.getUserID())
                .orElseThrow(() -> new RuntimeException("Employee not found!"));
        // check hoTen
        if (!nhanVien.getUser().getHoTen().equals(request.getHoTen())) {
            nhanVien.getUser().setHoTen(request.getHoTen());
        }
        // check email
        if (!nhanVien.getUser().getEmail().equals(request.getEmail())) {
            nhanVien.getUser().setEmail(request.getEmail());
        }
        // check password
        if (!nhanVien.getUser().getPassword().equals(request.getPassword())) {
            nhanVien.getUser().setPassword(request.getPassword());
        }
        // check chuc vu
        if (!nhanVien.getChucVu().equals(request.getChucVu())) {
            nhanVien.setChucVu(request.getChucVu());
        }
        // check luong co ban
        if (!Objects.equals(nhanVien.getLuongCoBan(), request.getLuongCoBan())) {
            nhanVien.setLuongCoBan(request.getLuongCoBan());
        }
        // check luong phu cap
        if (!Objects.equals(nhanVien.getLuongPhuCap(), request.getLuongPhuCap())) {
            nhanVien.setLuongPhuCap(request.getLuongPhuCap());
        }
        // check role
        List<UserRole> userRole = userRoleRepository.findByUser_UserID(request.getUserID());
        if (userRole.getFirst().getRole().getRoleID() != request.getRoleID()) {
            // find new role
            Role role = roleRepository.findById(request.getRoleID())
                    .orElseThrow(() -> new RuntimeException("Role not found!"));
            userRole.getFirst().setRole(role);
        }
        return null;
    }

    @Transactional
    public void finishPayment(String luongChiTIetID) {
        LuongChiTiet luongChiTiet = luongChiTietRepository.findById(luongChiTIetID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (luongChiTiet.getTrangThai() == 1) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        luongChiTiet.setTrangThai(1);
    }
}
