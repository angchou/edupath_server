package com.example.server.controller;

import com.example.server.dto.request.CreateVoucherRequest;
import com.example.server.dto.response.CheckVoucherResponse;
import com.example.server.dto.response.VoucherResponse;
import com.example.server.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("/api/voucher")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('FINANCE')")
    public List<VoucherResponse> getAllVouchers() {
        return voucherService.getAllVouchers();
    }

    @GetMapping("/check/{maApDung}")
    @PreAuthorize("isAuthenticated()")
    public CheckVoucherResponse checkVoucherApplied(@PathVariable String maApDung) {
        return voucherService.checkVoucherApplied(maApDung);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('FINANCE')")
    public ResponseEntity<?> createVoucher(@RequestBody CreateVoucherRequest request) {
        return voucherService.createVoucher(request);
    }

}
