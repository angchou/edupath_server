package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LearnerProfileResponse {
    private String userID;
    private String hoTen;
    private String email;
    private BigDecimal gpa;
    private String quocGiaDuHoc;
    private String nganhHoc;
    private LocalDate ngayTao;

    public LearnerProfileResponse(String userID, String hoTen, String email, BigDecimal gpa, String quocGiaDuHoc, String nganhHoc, LocalDate ngayTao) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.gpa = gpa;
        this.quocGiaDuHoc = quocGiaDuHoc;
        this.nganhHoc = nganhHoc;
        this.ngayTao = ngayTao;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
