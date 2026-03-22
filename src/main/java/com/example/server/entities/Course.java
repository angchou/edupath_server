package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "KHOAHOC")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KHOAHOC_ID", nullable = false)
    private String courseId;
    @Column(name = "TENKH", nullable = false)
    private String courseName;
    @Column(name = "NGAYTAO", nullable = false)
    private LocalDateTime courseCreatedAt;
    @Column(name = "NGAYTHAYDOITRANGTHAI")
    private LocalDateTime statusChangedAt;
    @Column(name = "LOAIKH", nullable = false)
    private Integer courseType;
    @Column(name = "MOTA", nullable = false)
    private String courseDescription;
    @Column(name = "MUCPHI", nullable = false)
    private BigDecimal coursePrice;
    @Column(name = "SLHV", nullable = false)
    private Integer courseSize;
    @Column(name = "TINHTRANG", nullable = false)
    private Integer courseStatus;

    @ManyToOne
    @JoinColumn(name = "MENTOR_ID", nullable = false)
    private Mentor mentor;

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

    public LocalDateTime getStatusChangedAt() {
        return statusChangedAt;
    }

    public void setStatusChangedAt(LocalDateTime statusChangedAt) {
        this.statusChangedAt = statusChangedAt;
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

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
