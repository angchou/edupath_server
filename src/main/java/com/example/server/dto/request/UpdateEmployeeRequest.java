package com.example.server.dto.request;

import java.math.BigDecimal;

public class UpdateEmployeeRequest {
    private String userID;
    private String hoTen;
    private String email;
    private String password;
    private Integer roleID;
    private String chucVu;
    private BigDecimal luongCoBan;
    private BigDecimal luongPhuCap;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
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
}
