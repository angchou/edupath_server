package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PayrollResponse {
    private String luongChiTietID;
    private BigDecimal luongThuong;
    private BigDecimal luongKhauTru;
    private BigDecimal luongCuoiCung;
    private Integer trangThai;
    private LocalDate ngayTao;

    public PayrollResponse(String luongChiTietID, BigDecimal luongThuong, BigDecimal luongKhauTru, BigDecimal luongCuoiCung, Integer trangThai, LocalDate ngayTao) {
        this.luongChiTietID = luongChiTietID;
        this.luongThuong = luongThuong;
        this.luongKhauTru = luongKhauTru;
        this.luongCuoiCung = luongCuoiCung;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
    }

    public String getLuongChiTietID() {
        return luongChiTietID;
    }

    public void setLuongChiTietID(String luongChiTietID) {
        this.luongChiTietID = luongChiTietID;
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

    public BigDecimal getLuongCuoiCung() {
        return luongCuoiCung;
    }

    public void setLuongCuoiCung(BigDecimal luongCuoiCung) {
        this.luongCuoiCung = luongCuoiCung;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
