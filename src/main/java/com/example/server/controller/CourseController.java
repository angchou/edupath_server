package com.example.server.controller;

import com.example.server.dto.request.CreateCourseRequest;
import com.example.server.dto.response.CourseCardResponse;
import com.example.server.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:6969")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/get/normal")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<CourseCardResponse> getNormalCourse() {
        return courseService.getNormalCourses();
    }

    @GetMapping("/get/mine")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<CourseCardResponse> getMyCourses() {
        return courseService.getMyCourses();
    }

    @GetMapping("/get/created_course")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public List<CourseCardResponse> getCreatedCourses() {
        return courseService.getCreatedCourses();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> createNewCourse(@RequestBody CreateCourseRequest request) {
        return courseService.createNewCourse(request);
    }

}
