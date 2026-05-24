package com.example.server.dto.response;

import java.math.BigDecimal;
import java.util.List;

public class RevenueResponse {
    private BigDecimal tongDoanhThu;
    private BigDecimal daRutThanhCong;
    private BigDecimal soDuKhaDung;
    private List<WithdrawResponse> danhSachRutTien;

    public RevenueResponse(BigDecimal tongDoanhThu, BigDecimal daRutThanhCong, BigDecimal soDuKhaDung, List<WithdrawResponse> danhSachRutTien) {
        this.tongDoanhThu = tongDoanhThu;
        this.daRutThanhCong = daRutThanhCong;
        this.soDuKhaDung = soDuKhaDung;
        this.danhSachRutTien = danhSachRutTien;
    }

    public BigDecimal getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(BigDecimal tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public BigDecimal getDaRutThanhCong() {
        return daRutThanhCong;
    }

    public void setDaRutThanhCong(BigDecimal daRutThanhCong) {
        this.daRutThanhCong = daRutThanhCong;
    }

    public BigDecimal getSoDuKhaDung() {
        return soDuKhaDung;
    }

    public void setSoDuKhaDung(BigDecimal soDuKhaDung) {
        this.soDuKhaDung = soDuKhaDung;
    }

    public List<WithdrawResponse> getDanhSachRutTien() {
        return danhSachRutTien;
    }

    public void setDanhSachRutTien(List<WithdrawResponse> danhSachRutTien) {
        this.danhSachRutTien = danhSachRutTien;
    }
}
