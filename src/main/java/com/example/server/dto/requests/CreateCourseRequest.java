package com.example.server.dto.requests;

import java.math.BigDecimal;

public class CreateCourseRequest {

    private String course_name;
    private Integer course_type;
    private String course_description;
    private BigDecimal course_price;
    private Integer course_size;
    private String mentor_id;

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getCourse_type() {
        return course_type;
    }

    public void setCourse_type(Integer course_type) {
        this.course_type = course_type;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public BigDecimal getCourse_price() {
        return course_price;
    }

    public void setCourse_price(BigDecimal course_price) {
        this.course_price = course_price;
    }

    public Integer getCourse_size() {
        return course_size;
    }

    public void setCourse_size(Integer course_size) {
        this.course_size = course_size;
    }

    public String getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(String mentor_id) {
        this.mentor_id = mentor_id;
    }
}
