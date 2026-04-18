package com.example.server.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CHINHSACH")
public class ChinhSach {
    @Id
    @Column(name = "CHINHSACH_ID", nullable = false)
    private String chinhSachID;
    @Column(name = "LOAICS", nullable = false)
    private String loaiCS;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "THOIHAN", nullable = false)
    private LocalDate thoiHan;
    @Column(name = "LOAIKH", nullable = false)
    private int loaiKH;

    public String getChinhSachID() {
        return chinhSachID;
    }

    public void setChinhSachID(String chinhSachID) {
        this.chinhSachID = chinhSachID;
    }

    public String getLoaiCS() {
        return loaiCS;
    }

    public void setLoaiCS(String loaiCS) {
        this.loaiCS = loaiCS;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public LocalDate getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(LocalDate thoiHan) {
        this.thoiHan = thoiHan;
    }

    public int getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(int loaiKH) {
        this.loaiKH = loaiKH;
    }
}
