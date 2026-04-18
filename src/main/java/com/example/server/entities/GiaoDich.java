package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GIAODICH")
public class GiaoDich {
    @Id
    @Column(name = "GIAODICH_ID", nullable = false)
    private String giaoDichID;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "NGAYGD")
    private LocalDate ngayGD;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;
    @Column(name = "CONGGD", nullable = false)
    private int congGD;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;
    @ManyToOne
    @JoinColumn(name = "HOCVIEN_ID")
    private HocVien hocVien;
    @ManyToOne
    @JoinColumn(name = "VOUCHER_ID")
    private Voucher voucher;

    public String getGiaoDichID() {
        return giaoDichID;
    }

    public void setGiaoDichID(String giaoDichID) {
        this.giaoDichID = giaoDichID;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public LocalDate getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(LocalDate ngayGD) {
        this.ngayGD = ngayGD;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getCongGD() {
        return congGD;
    }

    public void setCongGD(int congGD) {
        this.congGD = congGD;
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

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
