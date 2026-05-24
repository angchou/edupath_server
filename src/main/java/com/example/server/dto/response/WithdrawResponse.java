package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WithdrawResponse {
    private String rutTienID;
    private BigDecimal soTienRut;
    private LocalDate ngayRutTien;
    private Integer trangThai;
    private String tknhID;
    private String stk;
    private String tenNH;

    public WithdrawResponse(String rutTienID, BigDecimal soTienRut, LocalDate ngayRutTien, Integer trangThai, String tknhID, String stk, String tenNH) {
        this.rutTienID = rutTienID;
        this.soTienRut = soTienRut;
        this.ngayRutTien = ngayRutTien;
        this.trangThai = trangThai;
        this.tknhID = tknhID;
        this.stk = stk;
        this.tenNH = tenNH;
    }

    public String getRutTienID() {
        return rutTienID;
    }

    public void setRutTienID(String rutTienID) {
        this.rutTienID = rutTienID;
    }

    public BigDecimal getSoTienRut() {
        return soTienRut;
    }

    public void setSoTienRut(BigDecimal soTienRut) {
        this.soTienRut = soTienRut;
    }

    public LocalDate getNgayRutTien() {
        return ngayRutTien;
    }

    public void setNgayRutTien(LocalDate ngayRutTien) {
        this.ngayRutTien = ngayRutTien;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String gettknhID() {
        return tknhID;
    }

    public void settknhID(String tknhID) {
        this.tknhID = tknhID;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }
}
