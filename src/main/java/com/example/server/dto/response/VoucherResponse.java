package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VoucherResponse {
    private String voucherID;
    private String maApDung;
    private int loaiVoucher;
    private BigDecimal triGia;
    private int slToiDa;
    private int slDaSuDung;
    private LocalDate hanSuDung;
    private int trangThai;

    public VoucherResponse(String voucherID, String maApDung, int loaiVoucher, BigDecimal triGia, int slToiDa, int slDaSuDung, LocalDate hanSuDung, int trangThai) {
        this.voucherID = voucherID;
        this.maApDung = maApDung;
        this.loaiVoucher = loaiVoucher;
        this.triGia = triGia;
        this.slToiDa = slToiDa;
        this.slDaSuDung = slDaSuDung;
        this.hanSuDung = hanSuDung;
        this.trangThai = trangThai;
    }

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
