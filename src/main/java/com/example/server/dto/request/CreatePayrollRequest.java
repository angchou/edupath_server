package com.example.server.dto.request;

import java.math.BigDecimal;

public class CreatePayrollRequest {
    private String userID;
    private BigDecimal luongThuong;
    private BigDecimal luongKhauTru;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public BigDecimal getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(BigDecimal luongThuong) {
        this.luongThuong = luongThuong;
    }

    public BigDecimal getLuongKhauTru() {
        return luongKhauTru;
    }

    public void setLuongKhauTru(BigDecimal luongKhauTru) {
        this.luongKhauTru = luongKhauTru;
    }
}
