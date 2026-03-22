package com.example.server.controllers;

import com.example.server.dto.requests.CreateEmployeeRequest;
import com.example.server.dto.requests.UpdateEmployeeRequest;
import com.example.server.dto.responses.EmployeeViewResponse;
import com.example.server.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createNewEmployee(@RequestBody CreateEmployeeRequest request) {
        employeeService.createNewEmployee(request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeRequest request) {
        employeeService.updateEmployee(request);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'FINANCE', 'SUPPORT', 'QA')")
    public ResponseEntity<List<EmployeeViewResponse>> getEmployees() {
        List<EmployeeViewResponse> employees = employeeService.getEmployees();

        return ResponseEntity.ok(employees);
    }


}
