package com.example.server.dto.request;

import java.math.BigDecimal;

public class UpdateCourseRequest {
    private String khoaHocID;
    private String tenKH;
    private String moTa;
    private BigDecimal mucPhi;
    private Integer loaiKH;

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getMucPhi() {
        return mucPhi;
    }

    public void setMucPhi(BigDecimal mucPhi) {
        this.mucPhi = mucPhi;
    }

    public Integer getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(Integer loaiKH) {
        this.loaiKH = loaiKH;
    }
}
