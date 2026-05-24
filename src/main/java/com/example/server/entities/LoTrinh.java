package com.example.server.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOTRINH")
public class LoTrinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOTRINH_ID", nullable = false)
    private String loTrinhID;
    @Column(name = "LAKHUONMAU", nullable = false)
    private int laKhuonMau;
    @Column(name = "TRANGTHAI")
    private int trangThai;
    @Column(name = "MOTA")
    private String moTa;

    @OneToOne
    @JoinColumn(name = "HOCVIEN_ID")
    private HocVien hocVien;
    @OneToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;

    @OneToMany(mappedBy = "loTrinh", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DauViecLoTrinh> danhSachDauViec;

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoTrinhID() {
        return loTrinhID;
    }

    public void setLoTrinhID(String loTrinhID) {
        this.loTrinhID = loTrinhID;
    }

    public int getLaKhuonMau() {
        return laKhuonMau;
    }

    public void setLaKhuonMau(int laKhuonMau) {
        this.laKhuonMau = laKhuonMau;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
