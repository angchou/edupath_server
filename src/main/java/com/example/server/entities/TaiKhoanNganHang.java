package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TAIKHOANNGANHANG")
public class TaiKhoanNganHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TKNH_ID", nullable = false)
    private String tknhID;
    @Column(name = "STK", nullable = false)
    private String stk;
    @Column(name = "TENNH", nullable = false)
    private String tenNH;
    @Column(name = "TRANGTHAI")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;

    public String getTknhID() {
        return tknhID;
    }

    public void setTknhID(String tknhID) {
        this.tknhID = tknhID;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
