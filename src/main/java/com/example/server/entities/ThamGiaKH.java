package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "THAMGIAKH")
public class ThamGiaKH {
    @Id
    @Column(name = "THAMGIAKH_ID", nullable = false)
    private String thamGiaID;
    @Column(name = "NGAYDANGKY")
    private LocalDate ngayDangKy;
    @Column(name = "THOIHAN", nullable = false)
    private int thoiHan;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "HOCVIEN_ID")
    private HocVien hocVien;

    public String getThamGiaID() {
        return thamGiaID;
    }

    public void setThamGiaID(String thamGiaID) {
        this.thamGiaID = thamGiaID;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(int thoiHan) {
        this.thoiHan = thoiHan;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }
}
