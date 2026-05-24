package com.example.server.dto.response;

import java.math.BigDecimal;

public class CheckVoucherResponse {
    private String voucherID;
    private String maApDung;
    private int loaiVoucher;
    private BigDecimal triGia;

    public CheckVoucherResponse(String voucherID, String maApDung, int loaiVoucher, BigDecimal triGia) {
        this.voucherID = voucherID;
        this.maApDung = maApDung;
        this.loaiVoucher = loaiVoucher;
        this.triGia = triGia;
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
}
