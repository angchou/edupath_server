package com.example.server.controller;

import com.example.server.dto.request.CourseTextUploadRequest;
import com.example.server.dto.request.CreateCourseRequest;
import com.example.server.dto.response.CourseCardResponse;
import com.example.server.dto.response.CourseResourceResponse;
import com.example.server.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get/resource/{khoaHocID}")
    @PreAuthorize("isAuthenticated()")
    public List<CourseResourceResponse> getCourseRecourse(@PathVariable String khoaHocID) {
        return courseService.getCourseResource(khoaHocID);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public String createNewCourse(@RequestBody CreateCourseRequest request) {
        return courseService.createNewCourse(request);
    }

    @PostMapping("/create/{khoaHocID}/text")
    @PreAuthorize("hasRole('MENTOR')")
    public ResponseEntity<?> createText(@PathVariable String khoaHocID, @RequestBody CourseTextUploadRequest request) {
        return courseService.createText(khoaHocID, request);
    }

    @DeleteMapping("/delete/{khoaHocID}/{taiNguyenID}")
    @PreAuthorize("hasRole('MENTOR')")
    public ResponseEntity<?> deleteResource(@PathVariable String khoaHocID, @PathVariable String taiNguyenID) {
        return courseService.deleteResource(khoaHocID, taiNguyenID);
    }

}
