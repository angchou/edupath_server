package com.example.server.controllers;

import com.example.server.dto.requests.CreateCourseRequest;
import com.example.server.dto.responses.CourseViewResponse;
import com.example.server.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<List<CourseViewResponse>> getNormalCourses() {
        List<CourseViewResponse> courses = courseService.getNormalCourse();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('MENTOR')")
    public ResponseEntity<?> createNewCourse(@RequestBody CreateCourseRequest request) {
        courseService.createNewCourse(request);

        return ResponseEntity.ok().build();
    }

}
