package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "PHISAN")
public class PhiSan {
    @Id
    @Column(name = "PHISAN_ID", nullable = false)
    private String phiSanID;
    @Column(name = "DTNGUOIHUONGDAN", nullable = false)
    private BigDecimal dtNguoiHuogngDan;
    @Column(name = "TILE", nullable = false)
    private BigDecimal tiLe;
    @Column(name = "SOTIENPHISAN", nullable = false)
    private BigDecimal soTienPhiSan;

    @ManyToOne
    @JoinColumn(name = "GIAODICH_ID")
    private GiaoDich giaoDich;
    @ManyToOne
    @JoinColumn(name = "CHINHSACH_ID")
    private ChinhSach chinhSach;
    @ManyToOne
    @JoinColumn(name = "NGUOIHUONGDAN_ID")
    private NguoiHuongDan nguoiHuongDan;

    public String getPhiSanID() {
        return phiSanID;
    }

    public void setPhiSanID(String phiSanID) {
        this.phiSanID = phiSanID;
    }

    public BigDecimal getDtNguoiHuogngDan() {
        return dtNguoiHuogngDan;
    }

    public void setDtNguoiHuogngDan(BigDecimal dtNguoiHuogngDan) {
        this.dtNguoiHuogngDan = dtNguoiHuogngDan;
    }

    public BigDecimal getTiLe() {
        return tiLe;
    }

    public void setTiLe(BigDecimal tiLe) {
        this.tiLe = tiLe;
    }

    public BigDecimal getSoTienPhiSan() {
        return soTienPhiSan;
    }

    public void setSoTienPhiSan(BigDecimal soTienPhiSan) {
        this.soTienPhiSan = soTienPhiSan;
    }

    public GiaoDich getGiaoDich() {
        return giaoDich;
    }

    public void setGiaoDich(GiaoDich giaoDich) {
        this.giaoDich = giaoDich;
    }

    public ChinhSach getChinhSach() {
        return chinhSach;
    }

    public void setChinhSach(ChinhSach chinhSach) {
        this.chinhSach = chinhSach;
    }

    public NguoiHuongDan getNguoiHuongDan() {
        return nguoiHuongDan;
    }

    public void setNguoiHuongDan(NguoiHuongDan nguoiHuongDan) {
        this.nguoiHuongDan = nguoiHuongDan;
    }
}
