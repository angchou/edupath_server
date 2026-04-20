package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MentorProfileResponse {
    private String userID;
    private String hoTen;
    private String email;
    private BigDecimal trungBinhDanhGia;
    private BigDecimal doanhThu;
    private LocalDate ngayTao;

    public MentorProfileResponse(String userID, String hoTen, String email, BigDecimal trungBinhDanhGia, BigDecimal doanhThu, LocalDate ngayTao) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.trungBinhDanhGia = trungBinhDanhGia;
        this.doanhThu = doanhThu;
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

    public BigDecimal getTrungBinhDanhGia() {
        return trungBinhDanhGia;
    }

    public void setTrungBinhDanhGia(BigDecimal trungBinhDanhGia) {
        this.trungBinhDanhGia = trungBinhDanhGia;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
