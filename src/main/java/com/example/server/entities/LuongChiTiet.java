package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "LUONGCHITIET")
public class LuongChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LUONGCHITIET_ID")
    private String luongChiTietID;
    @Column(name = "LUONGTHUONG", nullable = false)
    private BigDecimal luongThuong;
    @Column(name = "LUONGKHAUTRU", nullable = false)
    private BigDecimal luongKhauTru;
    @Column(name = "LUONGCUOICUNG", nullable = false)
    private BigDecimal luongCuoiCung;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;
    @Column(name = "THOIGIAN")
    private LocalDate ngayTao;

    @ManyToOne
    @JoinColumn(name = "NHANVIEN_ID")
    private NhanVien nhanVien;
    @ManyToOne
    @JoinColumn(name = "LOAINGANSACH_ID")
    private LoaiNganSach loaiNganSach;

    public String getLuongChiTietID() {
        return luongChiTietID;
    }

    public void setLuongChiTietID(String luongChiTietID) {
        this.luongChiTietID = luongChiTietID;
    }

    public BigDecimal getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(BigDecimal luongThuong) {
        this.luongThuong = luongThuong;
    }

    public BigDecimal getLuongKhauTru() {
        return luongKhauTru;
    }

    public void setLuongKhauTru(BigDecimal luongKhauTru) {
        this.luongKhauTru = luongKhauTru;
    }

    public BigDecimal getLuongCuoiCung() {
        return luongCuoiCung;
    }

    public void setLuongCuoiCung(BigDecimal luongCuoiCung) {
        this.luongCuoiCung = luongCuoiCung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
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
