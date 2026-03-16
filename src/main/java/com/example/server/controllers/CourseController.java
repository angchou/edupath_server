package com.example.server.controllers;

import com.example.server.dto.responses.CourseViewResponse;
import com.example.server.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<List<CourseViewResponse>> getNormalCourses() {

        System.out.println("COURSE GETTING");

        List<CourseViewResponse> courses = courseService.getNormalCourse();
        return ResponseEntity.ok(courses);

    }

}
