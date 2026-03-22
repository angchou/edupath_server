package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "LEARNER")
public class Learner {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String learnerId;
    @Column(name = "GPA")
    private BigDecimal gpa;
    @Column(name = "QUOCGIADUHOC")
    private String quocGiaDuHoc;
    @Column(name = "NGANHHOC")
    private String NganhHoc;

    @MapsId
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public String getLearnerId() {
        return learnerId;
    }

    public void setLearnerId(String learnerId) {
        this.learnerId = learnerId;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public String getQuocGiaDuHoc() {
        return quocGiaDuHoc;
    }

    public void setQuocGiaDuHoc(String quocGiaDuHoc) {
        this.quocGiaDuHoc = quocGiaDuHoc;
    }

    public String getNganhHoc() {
        return NganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        NganhHoc = nganhHoc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
