package com.example.server.controller;

import com.example.server.dto.request.CreateTransactionRequest;
import com.example.server.dto.request.RefundTransactionRequest;
import com.example.server.dto.request.CreateWithdrawRequest;
import com.example.server.dto.response.RevenueResponse;
import com.example.server.dto.response.TransactionResponse;
import com.example.server.dto.response.WithdrawResponse;
import com.example.server.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/get/my")
    @PreAuthorize("isAuthenticated()")
    public List<TransactionResponse> getMyTransactions() {
        return transactionService.getMyTransactions();
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('FINANCE')")
    public List<TransactionResponse> getAllTransctions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/get/{voucherID}")
    @PreAuthorize("hasRole('FINANCE')")
    public List<TransactionResponse> getTransactionsByVoucher(@PathVariable String voucherID) {
        return transactionService.getTransactionsByVoucher(voucherID);
    }

    @GetMapping("/get/refund/{trangThai}")
    @PreAuthorize("hasRole('FINANCE')")
    public List<TransactionResponse> getRefundByStatus(@PathVariable Integer trangThai) {
        return transactionService.getRefundByStatus(trangThai);
    }

    @GetMapping("/get/revenue")
    @PreAuthorize("hasRole('MENTOR')")
    public RevenueResponse getMentorRevenue() {
        return transactionService.getMentorRevenue();
    }

    @GetMapping("/withdraw/get/my")
    @PreAuthorize("hasRole('MENTOR')")
    public List<WithdrawResponse> getMyWithdraws() {
        return transactionService.getMyWithdraws();
    }

    @PatchMapping("/refund/accept/{hoanTienID}")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> acceptRefund(@PathVariable String hoanTienID) {
        transactionService.acceptRefund(hoanTienID);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/refund/reject/{hoanTienID}")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> rejectRefund(@PathVariable String hoanTienID) {
        transactionService.rejectRefund(hoanTienID);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refund")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createRefundTransaction(@RequestBody RefundTransactionRequest request) {
        return transactionService.requestRefundTransaction(request);
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createTransaction(@RequestBody CreateTransactionRequest request) {
        return transactionService.createTransaction(request);
    }

    @PostMapping("/withdraw/create")
    @PreAuthorize("hasRole('MENTOR')")
    public ResponseEntity<?> createWithdraw(@RequestBody CreateWithdrawRequest request) {
        transactionService.createWithdraw(request);
        return ResponseEntity.ok().build();
    }

}
