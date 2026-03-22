package com.example.server.controllers;

import com.example.server.dto.responses.CustomerViewResponse;
import com.example.server.services.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping("/ban/{user_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> banCustomer(@PathVariable String user_id) {
        customerService.banCustomer(user_id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/unban/{user_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> unbanCustomer(@PathVariable String user_id) {
        customerService.unbanCustomer(user_id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/all/status={user_status}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<CustomerViewResponse>> getCustomerHasStatus(@PathVariable Integer user_status) {
        List<CustomerViewResponse> customers = customerService.getCustomerHasStatus(user_status);

        return ResponseEntity.ok(customers);
    }

}
