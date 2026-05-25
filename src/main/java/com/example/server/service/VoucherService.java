package com.example.server.service;

import com.example.server.dto.request.CreateVoucherRequest;
import com.example.server.dto.response.CheckVoucherResponse;
import com.example.server.dto.response.VoucherResponse;
import com.example.server.entities.Voucher;
import com.example.server.repositories.VoucherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    public List<VoucherResponse> getAllVouchers() {
        List<Voucher> danhSachVoucher = voucherRepository.findAll();
        return danhSachVoucher.stream().map(
                voucher -> new VoucherResponse(
                        voucher.getVoucherID(),
                        voucher.getMaApDung(),
                        voucher.getLoaiVoucher(),
                        voucher.getTriGia(),
                        voucher.getSlToiDa(),
                        voucher.getSlDaSuDung(),
                        voucher.getHanSuDung(),
                        voucher.getTrangThai()
                )
        ).toList();
    }

    public CheckVoucherResponse checkVoucherApplied(String maApDung) {
        Voucher voucher = voucherRepository.findByMaApDung(maApDung)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (
                voucher.getHanSuDung().isBefore(LocalDate.now())
                        || voucher.getSlDaSuDung() >= voucher.getSlToiDa()
                        || voucher.getTrangThai() == 0
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Voucher không hợp lệ hoặc đã hết hạn sử dụng");
        }
        return new CheckVoucherResponse(
                voucher.getVoucherID(),
                voucher.getMaApDung(),
                voucher.getLoaiVoucher(),
                voucher.getTriGia()
        );
    }

    @Transactional
    public ResponseEntity<?> createVoucher(CreateVoucherRequest request) {
        Voucher voucher = new Voucher();
        voucher.setMaApDung(request.getMaApDung());
        voucher.setLoaiVoucher(request.getLoaiVoucher());
        voucher.setTriGia(request.getTriGia());
        voucher.setSlToiDa(request.getSlToiDa());
        voucher.setHanSuDung(request.getHanSuDung());
        voucher.setTrangThai(1);

        voucherRepository.save(voucher);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> enableVoucher(String voucherID) {
        Voucher voucher = voucherRepository.findById(voucherID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (voucher.getTrangThai() == 0) {
            voucher.setTrangThai(1);
        }
        return ResponseEntity.ok().build();
    }

}
