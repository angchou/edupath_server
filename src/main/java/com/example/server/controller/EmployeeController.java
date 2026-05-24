package com.example.server.controller;

import com.example.server.dto.request.CreateEmployeeRequest;
import com.example.server.dto.request.CreatePayrollRequest;
import com.example.server.dto.request.UpdateEmployeeRequest;
import com.example.server.dto.response.EmployeeResponse;
import com.example.server.dto.response.PayrollResponse;
import com.example.server.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all/payroll")
    @PreAuthorize("hasRole('FINANCE')")
    public List<EmployeeResponse> getEmployeesInfoForPayroll () {
        return employeeService.getEmployeesInfoForPayroll();
    }

    @GetMapping("/payroll/{userID}")
    @PreAuthorize("hasRole('FINANCE')")
    public List<PayrollResponse> getEmployeePayroll (@PathVariable String userID) {
        return employeeService.getEmployeePayroll(userID);
    }

    @GetMapping("/deleted")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EmployeeResponse> getActiveEmployees() {
        return employeeService.getActiveEmployees();
    }

    @GetMapping("/newbie")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EmployeeResponse> getNewEmployees() {
        return employeeService.getNewEmployees();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @PostMapping("/create/payroll")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> createPayroll(@RequestBody CreatePayrollRequest request) {
        employeeService.createPayroll(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{nhanVienID}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteEmployee(@PathVariable String nhanVienID) {
        return employeeService.deleteEmployee(nhanVienID);
    }

    @PatchMapping("/edit")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeRequest request) {
        return employeeService.updateEmployee(request);
    }

    @PatchMapping("/finish-payment/{luongChiTietID}")
    @PreAuthorize("hasRole('FINANCE')")
    public ResponseEntity<?> finishPayment(@PathVariable String luongChiTietID) {
        employeeService.finishPayment(luongChiTietID);
        return ResponseEntity.ok().build();
    }

}
