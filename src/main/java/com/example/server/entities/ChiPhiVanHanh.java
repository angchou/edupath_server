package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CHIPHIVANHANH")
public class ChiPhiVanHanh {
    @Id
    @Column(name = "CPVH_ID", nullable = false)
    private String cpvhID;
    @Column(name = "LOAICPVH", nullable = false)
    private String loaiCPVH;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "NGAYPHATSINH")
    private LocalDate ngayPhatSinh;

    @ManyToOne
    @JoinColumn(name = "NHANVIEN_ID")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "LOAINGANSACH_ID")
    private LoaiNganSach loaiNganSach;

    public String getCpvhID() {
        return cpvhID;
    }

    public void setCpvhID(String cpvhID) {
        this.cpvhID = cpvhID;
    }

    public String getLoaiCPVH() {
        return loaiCPVH;
    }

    public void setLoaiCPVH(String loaiCPVH) {
        this.loaiCPVH = loaiCPVH;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public LocalDate getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public void setNgayPhatSinh(LocalDate ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public LoaiNganSach getLoaiNganSach() {
        return loaiNganSach;
    }

    public void setLoaiNganSach(LoaiNganSach loaiNganSach) {
        this.loaiNganSach = loaiNganSach;
    }
}
