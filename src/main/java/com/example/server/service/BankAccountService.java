package com.example.server.service;

import com.example.server.dto.request.CreateBankAccountRequest;
import com.example.server.dto.response.BankAccountResponse;
import com.example.server.entities.NguoiHuongDan;
import com.example.server.entities.TaiKhoanNganHang;
import com.example.server.repositories.NguoiHuongDanRepository;
import com.example.server.repositories.TKNHRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class BankAccountService {

    @Autowired
    private TKNHRepository tknhRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;

    public List<BankAccountResponse> getMyBankAccounts() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<TaiKhoanNganHang> danhSach = tknhRepository.findByNguoiHuongDan_UserID(userID);

        return danhSach.stream().map(
                tk -> new BankAccountResponse(
                        tk.getTknhID(),
                        tk.getStk(),
                        tk.getTenNH(),
                        tk.getTrangThai()
                )
        ).toList();
    }

    @Transactional
    public ResponseEntity<?> createBankAccount(CreateBankAccountRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        NguoiHuongDan nguoiHuongDan = nguoiHuongDanRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TaiKhoanNganHang taiKhoanNganHang = new TaiKhoanNganHang();
        taiKhoanNganHang.setNguoiHuongDan(nguoiHuongDan);
        taiKhoanNganHang.setStk(request.getStk());
        taiKhoanNganHang.setTenNH(request.getTenNH());
        taiKhoanNganHang.setTrangThai(1);
        tknhRepository.save(taiKhoanNganHang);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> disableBankAccount(String tknhID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        TaiKhoanNganHang taiKhoanNganHang = tknhRepository.findById(tknhID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiKhoanNganHang.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (taiKhoanNganHang.getTrangThai() == 1) {
            taiKhoanNganHang.setTrangThai(0);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(). build();
    }

    @Transactional
    public ResponseEntity<?> enableBankAccount(String tknhID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        TaiKhoanNganHang taiKhoanNganHang = tknhRepository.findById(tknhID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiKhoanNganHang.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (taiKhoanNganHang.getTrangThai() == 0) {
            taiKhoanNganHang.setTrangThai(1);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(). build();
    }

    @Transactional
    public ResponseEntity<?> updateBankAccount(String tknhID, CreateBankAccountRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        TaiKhoanNganHang taiKhoanNganHang = tknhRepository.findById(tknhID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiKhoanNganHang.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (!taiKhoanNganHang.getStk().equals(request.getStk())) {
            taiKhoanNganHang.setStk(request.getStk());
        }
        if (!taiKhoanNganHang.getTenNH().equals(request.getTenNH())) {
            taiKhoanNganHang.setTenNH(request.getTenNH());
        }

        return ResponseEntity.ok().build();
    }
}
