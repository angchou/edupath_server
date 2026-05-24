package com.example.server.dto.request;

import java.math.BigDecimal;

public class CreateCourseRequest {
    private String tenKH;
    private int loaiKH;
    private String moTa;
    private BigDecimal mucPhi;
    private int slhv;
    private int thoiHan;

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        this.loaiKH = loaiKH;
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

    public int getSlhv() {
        return slhv;
    }

    public void setSlhv(int slhv) {
        this.slhv = slhv;
    }
}
