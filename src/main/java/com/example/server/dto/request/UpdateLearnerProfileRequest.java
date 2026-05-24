package com.example.server.dto.request;

import java.math.BigDecimal;

public class UpdateLearnerProfileRequest {
    private String hoTen;
    private String email;
    private BigDecimal gpa;
    private String quocGiaDuHoc;
    private String nganhHoc;

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
}
