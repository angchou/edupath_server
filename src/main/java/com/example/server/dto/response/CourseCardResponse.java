package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CourseCardResponse {
    private String khoaHocID;
    private String tenKH;
    private String moTa;
    private int slhv;
    private LocalDate ngayTao;
    private BigDecimal mucPhi;
    private String url;

    // nguoi huong dan
    private String userID;
    private String hoTen;

    public CourseCardResponse(String khoaHocID, String tenKH, String moTa, int slhv, LocalDate ngayTao, BigDecimal mucPhi, String url, String userID, String hoTen) {
        this.khoaHocID = khoaHocID;
        this.tenKH = tenKH;
        this.moTa = moTa;
        this.slhv = slhv;
        this.ngayTao = ngayTao;
        this.mucPhi = mucPhi;
        this.url = url;
        this.userID = userID;
        this.hoTen = hoTen;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public BigDecimal getMucPhi() {
        return mucPhi;
    }

    public void setMucPhi(BigDecimal mucPhi) {
        this.mucPhi = mucPhi;
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

    public int getSlhv() {
        return slhv;
    }

    public void setSlhv(int slhv) {
        this.slhv = slhv;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
