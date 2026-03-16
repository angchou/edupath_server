package com.example.server.dto.responses;

import com.example.server.dto.summaries.MentorSummaryResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CourseViewResponse {

    private String courseId;
    private String courseName;
    private LocalDateTime courseCreatedAt;
    private Integer courseType;
    private String courseDescription;
    private BigDecimal coursePrice;
    private Integer courseSize;
    private Integer courseStatus;
    private Double courseAverageRating;

    private MentorSummaryResponse mentorSummaryResponse;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCourseCreatedAt() {
        return courseCreatedAt;
    }

    public void setCourseCreatedAt(LocalDateTime courseCreatedAt) {
        this.courseCreatedAt = courseCreatedAt;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public BigDecimal getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(BigDecimal coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getCourseSize() {
        return courseSize;
    }

    public void setCourseSize(Integer courseSize) {
        this.courseSize = courseSize;
    }

    public Integer getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        this.courseStatus = courseStatus;
    }

    public Double getCourseAverageRating() {
        return courseAverageRating;
    }

    public void setCourseAverageRating(Double courseAverageRating) {
        this.courseAverageRating = courseAverageRating;
    }

    public MentorSummaryResponse getMentorSummaryResponse() {
        return mentorSummaryResponse;
    }

    public void setMentorSummaryResponse(MentorSummaryResponse mentorSummaryResponse) {
        this.mentorSummaryResponse = mentorSummaryResponse;
    }
}
