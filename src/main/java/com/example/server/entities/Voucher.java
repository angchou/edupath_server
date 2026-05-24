package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "VOUCHER")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOUCHER_ID", nullable = false)
    private String voucherID;
    @Column(name = "MAAPDUNG", nullable = false)
    private String maApDung;
    @Column(name = "LOAIVOUCHER", nullable = false)
    private int loaiVoucher;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "SLTOIDA", nullable = false)
    private int slToiDa;
    @Column(name = "SLDASUDUNG", nullable = false)
    private int slDaSuDung;
    @Column(name = "HANSUDUNG", nullable = false)
    private LocalDate hanSuDung;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public String getMaApDung() {
        return maApDung;
    }

    public void setMaApDung(String maApDung) {
        this.maApDung = maApDung;
    }

    public int getLoaiVoucher() {
        return loaiVoucher;
    }

    public void setLoaiVoucher(int loaiVoucher) {
        this.loaiVoucher = loaiVoucher;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public int getSlToiDa() {
        return slToiDa;
    }

    public void setSlToiDa(int slToiDa) {
        this.slToiDa = slToiDa;
    }

    public int getSlDaSuDung() {
        return slDaSuDung;
    }

    public void setSlDaSuDung(int slDaSuDung) {
        this.slDaSuDung = slDaSuDung;
    }

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
