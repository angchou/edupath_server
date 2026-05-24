package com.example.server.controller;

import com.example.server.dto.request.ChangePasswordRequest;
import com.example.server.dto.request.UpdateLearnerProfileRequest;
import com.example.server.dto.request.UpdateMentorProfileRequest;
import com.example.server.dto.response.EmployeeProfileResponse;
import com.example.server.dto.response.LearnerProfileResponse;
import com.example.server.dto.response.MentorProfileResponse;
import com.example.server.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/password/change")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request) {
        return accountService.changePassword(request);
    }

    @PatchMapping("/learner/profile/change")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<?> changeLearnerProfile(@RequestBody UpdateLearnerProfileRequest request) {
        return accountService.changeLearnerProfile(request);
    }

    @PatchMapping("/mentor/profile/change")
    @PreAuthorize("hasAnyRole('MENTOR', 'SUPPORT', 'FINANCE', 'ADMIN', 'QA')")
    public ResponseEntity<?> changeMentorProfile(@RequestBody UpdateMentorProfileRequest request) {
        return accountService.changeMentorProfile(request);
    }

}
