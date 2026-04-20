package com.example.server.controller;

import com.example.server.dto.response.EmployeeProfileResponse;
import com.example.server.dto.response.LearnerProfileResponse;
import com.example.server.dto.response.MentorProfileResponse;
import com.example.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/learner/profile")
    @PreAuthorize("hasRole('LEARNER')")
    public LearnerProfileResponse getLearnerProfile() {
        return accountService.getLearnerProfile();
    }

    @GetMapping("/mentor/profile")
    @PreAuthorize("hasRole('MENTOR')")
    public MentorProfileResponse getMentorProfile() {
        return accountService.getMentorProfile();
    }

    @GetMapping("/emp/profile")
    @PreAuthorize("hasAnyRole('SUPPORT', 'QA', 'FINANCE', 'ADMIN')")
    public EmployeeProfileResponse getEmployeeProfile() {
        return accountService.getEmployeeProfile();
    }

}
