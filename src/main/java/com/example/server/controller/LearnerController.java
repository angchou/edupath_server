package com.example.server.controller;

import com.example.server.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("api/learner")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping("/application/get")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<?> getMyApplication() {
        return learnerService.getMyApplication();
    }

    @GetMapping("/view-pdf/{fileName}")
    @PreAuthorize("hasAnyRole('LEARNER', 'QA', 'ADMIN')")
    public ResponseEntity<?> viewPDF(@PathVariable String fileName) {
        return learnerService.viewPDF(fileName);
    }

    @DeleteMapping("/application/delete")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<?> deleteApplication() {
        return learnerService.deleteApplication();
    }

    @PostMapping("/mentor_application/upload")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<?> uploadMentorApplication(@RequestParam("file") MultipartFile file, @RequestParam("tenHoSo") String tenHoSo) {
        return learnerService.uploadMentorApplication(file, tenHoSo);
    }
}
