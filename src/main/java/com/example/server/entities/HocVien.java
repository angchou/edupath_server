package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "HOCVIEN")
public class HocVien {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userID;
    @Column(name = "GPA")
    private BigDecimal gpa;
    @Column(name = "QUOCGIADUHOC")
    private String quocGiaDuHoc;
    @Column(name = "NGANHHOC")
    private String nganhHoc;

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    private Users user;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
