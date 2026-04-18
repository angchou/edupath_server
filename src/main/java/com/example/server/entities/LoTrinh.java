package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LOTRINH")
public class LoTrinh {
    @Id
    @Column(name = "LOTRINH_ID", nullable = false)
    private String loTrinhID;
    @Column(name = "LAKHUONMAU", nullable = false)
    private int laKhuonMau;

    @OneToOne
    @MapsId
    @JoinColumn(name = "HOCVIEN_ID")
    private HocVien hocVien;
    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;

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
}
