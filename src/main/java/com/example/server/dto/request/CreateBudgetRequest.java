package com.example.server.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateBudgetRequest {
    private String loaiNganSachID;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private BigDecimal triGia;

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
