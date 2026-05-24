package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "THAMGIAKH")
public class ThamGiaKH {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THAMGIAKH_ID", nullable = false)
    private String thamGiaID;
    @Column(name = "NGAYDANGKY", nullable = false)
    private LocalDate ngayDangKy;
    @Column(name = "NGAYHETHAN", nullable = false)
    private LocalDate ngayHetHan;

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

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
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
