package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PHIEUDANHDAUKH")
public class PhieuDanhDauKH {
    @Id
    @Column(name = "PHIEUDANHDAUKH_ID", nullable = false)
    private String phieuDanhDauID;
    @Column(name = "MOTA", nullable = false)
    private String moTa;
    @Column(name = "MUCDANHDAU", nullable = false)
    private int mucDanhDau;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;
    @ManyToOne
    @JoinColumn(name = "NHANVIENDANHDAU")
    private NhanVien nhanVien;

    public String getPhieuDanhDauID() {
        return phieuDanhDauID;
    }

    public void setPhieuDanhDauID(String phieuDanhDauID) {
        this.phieuDanhDauID = phieuDanhDauID;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMucDanhDau() {
        return mucDanhDau;
    }

    public void setMucDanhDau(int mucDanhDau) {
        this.mucDanhDau = mucDanhDau;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
