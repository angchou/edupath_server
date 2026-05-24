package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BudgetResponse {
    private String nganSachID;
    private String loaiNganSachID;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private BigDecimal triGia;

    public BudgetResponse(String nganSachID, String loaiNganSachID, LocalDate ngayBatDau, LocalDate ngayKetThuc, BigDecimal triGia) {
        this.nganSachID = nganSachID;
        this.loaiNganSachID = loaiNganSachID;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.triGia = triGia;
    }

    public String getNganSachID() {
        return nganSachID;
    }

    public void setNganSachID(String nganSachID) {
        this.nganSachID = nganSachID;
    }

    public String getLoaiNganSachID() {
        return loaiNganSachID;
    }

    public void setLoaiNganSachID(String loaiNganSachID) {
        this.loaiNganSachID = loaiNganSachID;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }
}
