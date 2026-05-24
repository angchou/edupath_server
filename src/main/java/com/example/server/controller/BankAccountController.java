package com.example.server.controller;

import com.example.server.dto.request.CreateBankAccountRequest;
import com.example.server.dto.response.BankAccountResponse;
import com.example.server.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank_account")
@CrossOrigin(origins = "http://localhost:6969")
public class BankAccountController {

    @Autowired
    public BankAccountService bankAccountService;

    @GetMapping("/get/my")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public List<BankAccountResponse> getMyBankAccounts() {
        return bankAccountService.getMyBankAccounts();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> createBankAccount(@RequestBody CreateBankAccountRequest request) {
        return bankAccountService.createBankAccount(request);
    }

    @PatchMapping("/disable/{tknhID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> disableBankAccount(@PathVariable String tknhID) {
        return bankAccountService.disableBankAccount(tknhID);
    }

    @PatchMapping("/enable/{tknhID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> enableBankAccount(@PathVariable String tknhID) {
        return bankAccountService.enableBankAccount(tknhID);
    }

    @PatchMapping("/update/{tknhID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> updateBankAccount(@PathVariable String tknhID, @RequestBody CreateBankAccountRequest request) {
        return bankAccountService.updateBankAccount(tknhID, request);
    }

}
