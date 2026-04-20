package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeProfileResponse {
    private String userID;
    private String hoTen;
    private String email;
    private String chucVu;
    private BigDecimal luongCoBan;
    private BigDecimal luongPhuCap;
    private LocalDate ngayTao;

    public EmployeeProfileResponse(String userID, String hoTen, String email, String chucVu, BigDecimal luongCoBan, BigDecimal luongPhuCap, LocalDate ngayTao) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.luongPhuCap = luongPhuCap;
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

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public BigDecimal getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(BigDecimal luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public BigDecimal getLuongPhuCap() {
        return luongPhuCap;
    }

    public void setLuongPhuCap(BigDecimal luongPhuCap) {
        this.luongPhuCap = luongPhuCap;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
