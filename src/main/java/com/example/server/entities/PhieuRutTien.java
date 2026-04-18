package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PHIEURUTTIEN")
public class PhieuRutTien {
    @Id
    @Column(name = "RUTTIEN_ID", nullable = false)
    private String rutTienID;
    @Column(name = "SOTIENRUT", nullable = false)
    private BigDecimal soTienRut;
    @Column(name = "NGAYRUTTIEN")
    private LocalDate ngayRutTien;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;

    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;
    @ManyToOne
    @JoinColumn(name = "TKNH_ID")
    private TaiKhoanNganHang tknh;

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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }

    public TaiKhoanNganHang getTknh() {
        return tknh;
    }

    public void setTknh(TaiKhoanNganHang tknh) {
        this.tknh = tknh;
    }
}
