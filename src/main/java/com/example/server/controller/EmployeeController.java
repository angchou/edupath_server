package com.example.server.controller;

import com.example.server.dto.response.EmployeeResponse;
import com.example.server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
@CrossOrigin(origins = "http://localhost:6969")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }



}
