package com.example.server.controller;

import com.example.server.dto.request.CreateBudgetRequest;
import com.example.server.dto.response.BudgetResponse;
import com.example.server.dto.response.BudgetTypeResponse;
import com.example.server.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
@CrossOrigin(origins = "http://localhost:6969")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @GetMapping("/get/type")
    @PreAuthorize("hasRole('FINANCE')")
    public List<BudgetTypeResponse> getBudgetTypes() {
        return budgetService.getBudgetTypes();
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('FINANCE')")
    public List<BudgetResponse> getAllBudgets() {
        return budgetService.getAllBudgets();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> createBudget(@RequestBody CreateBudgetRequest request) {
        budgetService.createBudget(request);
        return ResponseEntity.ok().build();
    }
}
