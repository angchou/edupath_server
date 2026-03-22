package com.example.server.dto.summaries;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MentorSummaryResponse {

    private String mentorId;
    private String mentorUserName;
    private String mentorEmail;
    private Integer mentorStatus;
    private LocalDateTime mentorCreatedAt;
    private BigDecimal mentorAverageRating;

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorUserName() {
        return mentorUserName;
    }

    public void setMentorUserName(String mentorUserName) {
        this.mentorUserName = mentorUserName;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public Integer getMentorStatus() {
        return mentorStatus;
    }

    public void setMentorStatus(Integer mentorStatus) {
        this.mentorStatus = mentorStatus;
    }

    public LocalDateTime getMentorCreatedAt() {
        return mentorCreatedAt;
    }

    public void setMentorCreatedAt(LocalDateTime mentorCreatedAt) {
        this.mentorCreatedAt = mentorCreatedAt;
    }

    public BigDecimal getMentorAverageRating() {
        return mentorAverageRating;
    }

    public void setMentorAverageRating(BigDecimal mentorAverageRating) {
        this.mentorAverageRating = mentorAverageRating;
    }
}
