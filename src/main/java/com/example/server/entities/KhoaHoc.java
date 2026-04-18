package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "KHOAHOC")
public class KhoaHoc {
    @Id
    @Column(name = "KHOAHOC_ID", nullable = false)
    private String khoaHocID;
    @Column(name = "TENKH", nullable = false)
    private String tenKH;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;
    @Column(name = "NGAYTHAYDOITRANGTHAI")
    private LocalDate ngayThayDoiTrangThai;
    @Column(name = "LOAIKH", nullable = false)
    private int loaiKH;
    @Column(name = "MOTA", nullable = false)
    private String moTa;
    @Column(name = "MUCPHI", nullable = false)
    private BigDecimal mucPhi;
    @Column(name = "SLHV", nullable = false)
    private int slhv;
    @Column(name = "TINHTRANG")
    private int tinhTrang;

    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;

    public String getKhoaHocID() {
        return khoaHocID;
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

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDate getNgayThayDoiTrangThai() {
        return ngayThayDoiTrangThai;
    }

    public void setNgayThayDoiTrangThai(LocalDate ngayThayDoiTrangThai) {
        this.ngayThayDoiTrangThai = ngayThayDoiTrangThai;
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

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }
}
