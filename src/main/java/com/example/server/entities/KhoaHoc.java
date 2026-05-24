package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "KHOAHOC")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KHOAHOC_ID", nullable = false)
    private String khoaHocID;
    @Column(name = "TENKH", nullable = false)
    private String tenKH;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;
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
    @Column(name = "URL")
    private String url;
    @Column(name = "THOIHAN", nullable = false)
    private Integer thoiHan;

    @ManyToOne
    @JoinColumn(name = "NHANVIENKIEMDUYET")
    private NhanVien nhanVienKiemDuyet;

    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN")
    private NguoiHuongDan nguoiHuongDan;

    public NhanVien getNhanVienKiemDuyet() {
        return nhanVienKiemDuyet;
    }

    public void setNhanVienKiemDuyet(NhanVien nhanVienKiemDuyet) {
        this.nhanVienKiemDuyet = nhanVienKiemDuyet;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }

    public Integer getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Integer thoiHan) {
        this.thoiHan = thoiHan;
    }
}
