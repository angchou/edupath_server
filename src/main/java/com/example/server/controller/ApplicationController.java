package com.example.server.controller;

import com.example.server.dto.response.ApplicationResponse;
import com.example.server.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/get/{trangThai}")
    @PreAuthorize("hasAnyRole('QA', 'ADMIN')")
    public List<ApplicationResponse> getApplication(@PathVariable Integer trangThai) {
        return applicationService.getApplication(trangThai);
    }

    @PatchMapping("/approve/{hoSoID}")
    @PreAuthorize("hasAnyRole('QA')")
    public ResponseEntity<?> approveApplication(@PathVariable String hoSoID) {
        applicationService.approveApplication(hoSoID);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/reject/{hoSoID}")
    @PreAuthorize("hasAnyRole('QA')")
    public ResponseEntity<?> rejectApplication(@PathVariable String hoSoID) {
        applicationService.rejectApplication(hoSoID);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/grant/{hoSoID}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> grantMentor(@PathVariable String hoSoID) {
        applicationService.grantMentor(hoSoID);
        return ResponseEntity.ok().build();
    }

}
