package com.example.server.controller;

import com.example.server.dto.request.*;
import com.example.server.dto.response.*;
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

    // GET

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<CourseCardResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/get/{khoaHocID}")
    @PreAuthorize("isAuthenticated()")
    public CourseCardResponse getCourse(@PathVariable String khoaHocID) {
        return courseService.getCourse(khoaHocID);
    }

    @GetMapping("/get/normal")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<CourseCardResponse> getPublicCourses() {
        return courseService.getPublicCourses();
    }

    @GetMapping("/get/request_open")
    @PreAuthorize("hasAnyRole('QA')")
    public List<CourseCardResponse> getRequestOpenCourses() {
        return courseService.getRequestOpenCourses();
    }

    @GetMapping("/get/waiting_public")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<CourseCardResponse> getWaitingPublicCourses() {
        return courseService.getWaitingPublicCourses();
    }

    @GetMapping("/get/locked_public")
    @PreAuthorize("hasAnyRole('ADMIN', 'QA')")
    public List<CourseCardResponse> getLockedAndPublicCourses() {
        return courseService.getLockedAndPublicCourses();
    }

    @GetMapping("/get/banned")
    @PreAuthorize("hasAnyRole('ADMIN', 'QA')")
    public List<CourseCardResponse> getBannedCourses() {
        return courseService.getBannedCourses();
    }

    @GetMapping("/get/active_course")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<CourseCardResponse> getMyActiveCourses() {
        return courseService.getMyActiveCourses();
    }

    @GetMapping("/get/my_course")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<CourseCardResponse> getMyCourses() {
        return courseService.getMyCourses();
    }

    @GetMapping("/get/created_course")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public List<CourseCardResponse> getCreatedCourses() {
        return courseService.getCreatedCourses();
    }

    @GetMapping("/get/demo/lesson/{khoaHocID}")
    public List<LessonResponse> getDemoLessons(@PathVariable String khoaHocID) {
        return courseService.getDemoLessons(khoaHocID);
    }

    @GetMapping("/get/demo/resource/{baiHocID}")
    public List<CourseResourceResponse> getDemoResource(@PathVariable String baiHocID) {
        return courseService.getDemoResource(baiHocID);
    }

    @GetMapping("/get/resource/{baiHocID}")
    @PreAuthorize("isAuthenticated()")
    public List<CourseResourceResponse> getLessonResource(@PathVariable String baiHocID) {
        return courseService.getLessonResource(baiHocID);
    }

    @GetMapping("/get/lesson/{khoaHocID}")
    @PreAuthorize("isAuthenticated()")
    public List<LessonResponse> getLessons(@PathVariable String khoaHocID) {
        return courseService.getLessons(khoaHocID);
    }

    @GetMapping("/get/rating/{khoaHocID}")
    @PreAuthorize("isAuthenticated()")
    public List<RatingResponse> getCourseRatings(@PathVariable String khoaHocID) {
        return courseService.getCourseRatings(khoaHocID);
    }

    @GetMapping("/get/rating/single/{khoaHocID}")
    @PreAuthorize("isAuthenticated()")
    public RatingResponse getRating(@PathVariable String khoaHocID) {
        return courseService.getRating(khoaHocID);
    }

    @GetMapping("/get/mark/{khoaHocID}")
    @PreAuthorize("hasAnyRole('MENTOR', 'QA', 'ADMIN')")
    public List<CourseMarkResponse> getCourseMarks(@PathVariable String khoaHocID) {
        return courseService.getCourseMarks(khoaHocID);
    }

    // POST
    @PostMapping("/create/mark")
    @PreAuthorize("hasAnyRole('QA')")
    public ResponseEntity<?> createMarkCourse(@RequestBody CreateMarkCourseRequest request) {
        return courseService.createMarkCourse(request);
    }

    @PostMapping("/lesson/create")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> createLesson(@RequestBody CreateLessonRequest request) {
        return courseService.createLesson(request);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public String createNewCourse(@RequestBody CreateCourseRequest request) {
        return courseService.createNewCourse(request);
    }

    @PostMapping("/create/text_block")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> createTextBlock(@RequestBody CreateBlockRequest request) {
        return courseService.createTextBlock(request);
    }

    @PostMapping("/create/rating")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> createRating(@RequestBody CreateRatingRequest request) {
        return courseService.createRating(request);
    }

    // DELETE
    @DeleteMapping("/delete/mark/{phieuDanhDauID}")
    public ResponseEntity<?> deleteCourseMark(@PathVariable String phieuDanhDauID) {
        return courseService.deleteMarkCourse(phieuDanhDauID);
    }

    @DeleteMapping("/lesson/del/{baiHocID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> deleteLesson(@PathVariable String baiHocID) {
        return courseService.deleteLesson(baiHocID);
    }

    @DeleteMapping("/resource/del/{taiNguyenID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> deleteResource(@PathVariable String taiNguyenID) {
        return courseService.deleteResource(taiNguyenID);
    }

    // PATCH
    @PatchMapping("/lock/{khoaHocID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> lockCourse(@PathVariable String khoaHocID) {
        return courseService.lockCourse(khoaHocID);
    }

    @PatchMapping("/update")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> updateCourse(@RequestBody UpdateCourseRequest request) {
        return courseService.updateCourse(request);
    }

    @PatchMapping("/approve/{khoaHocID}")
    @PreAuthorize("hasAnyRole('QA')")
    public ResponseEntity<?> approveCourse(@PathVariable String khoaHocID) {
        return courseService.approveCourse(khoaHocID);
    }

    @PatchMapping("/reject/{khoaHocID}")
    @PreAuthorize("hasAnyRole('QA', 'ADMIN')")
    public ResponseEntity<?> rejectCourse(@PathVariable String khoaHocID) {
        return courseService.rejectCourse(khoaHocID);
    }

    @PatchMapping("/request_open/{khoaHocID}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> requestOpenCourse(@PathVariable String khoaHocID) {
        return courseService.requestOpenCourse(khoaHocID);
    }

    @PatchMapping("/lesson/update")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> updateLesson(@RequestBody UpdateLessonRequest request) {
        return courseService.updateLesson(request);
    }

    @PatchMapping("/lesson/swap_prio")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> swapLessonPriority(@RequestBody SwapLessonPriorityRequest request) {
        return courseService.swapLessonPriority(request);
    }

    @PatchMapping("/resource/update")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> updateResourceBlock(@RequestBody UpdateBlockRequest request) {
        return courseService.updateResourceBlock(request);
    }

    @PatchMapping("/resource/swap_prio")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> swapResourcePriority(@RequestBody SwapResourcePriorityRequest request) {
        return courseService.swapResourcePriority(request);
    }

    @PatchMapping("/ban/{khoaHocID}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> banCourse(@PathVariable String khoaHocID) {
        return courseService.banCourse(khoaHocID);
    }

    @PatchMapping("/unban/{khoaHocID}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> unbanCourse(@PathVariable String khoaHocID) {
        return courseService.unbanCourse(khoaHocID);
    }

    @PatchMapping("/public/{khoaHocID}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> publicCourse(@PathVariable String khoaHocID) {
        return courseService.publicCourse(khoaHocID);
    }

    @PatchMapping("/delete/{khoaHocID}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable String khoaHocID) {
        return courseService.deleteCourse(khoaHocID);
    }
}
