package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "MENTOR")
public class Mentor {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String mentorId;
    @Column(name = "TRUNGBINHDANHGIA")
    private BigDecimal averageRating;
    @Column(name = "DOANHTHU")
    private BigDecimal outcome;

    @MapsId
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "mentor")
    private List<Course> courses;

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public BigDecimal getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(BigDecimal averageRating) {
        this.averageRating = averageRating;
    }

    public BigDecimal getOutcome() {
        return outcome;
    }

    public void setOutcome(BigDecimal outcome) {
        this.outcome = outcome;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
