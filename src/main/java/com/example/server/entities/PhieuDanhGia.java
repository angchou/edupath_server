package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PHIEUDANHGIA")
public class PhieuDanhGia {
    @Id
    @Column(name = "PHIEUDANHGIA_ID", nullable = false)
    private String phieuDanhGiaID;
    @Column(name = "CHITIET")
    private String chiTiet;
    @Column(name = "DIEMDANHGIA", nullable = false)
    private int diemDanhGia;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;

    public String getPhieuDanhGiaID() {
        return phieuDanhGiaID;
    }

    public void setPhieuDanhGiaID(String phieuDanhGiaID) {
        this.phieuDanhGiaID = phieuDanhGiaID;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public int getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}