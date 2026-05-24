package com.example.server.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateVoucherRequest {
    private String maApDung;
    private int loaiVoucher;
    private BigDecimal triGia;
    private int slToiDa;
    private LocalDate hanSuDung;

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

    public LocalDate getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(LocalDate hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
}
