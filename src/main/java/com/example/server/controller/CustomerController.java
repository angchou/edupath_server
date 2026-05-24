package com.example.server.controller;

import com.example.server.dto.response.CustomerResponse;
import com.example.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:6969")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get/{trangThai}")
    public List<CustomerResponse> getCustomerByStatus(@PathVariable Integer trangThai) {
        return customerService.getCustomersByTrangThai(trangThai);
    }

    @PatchMapping("/ban/{userID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> banCustomer (@PathVariable String userID) {
        customerService.banCustomer(userID);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/unban/{userID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> unbanCustomer (@PathVariable String userID) {
        customerService.unbanCustomer(userID);
        return ResponseEntity.ok().build();
    }

}
