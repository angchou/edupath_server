package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "NGANSACH")
public class NganSach {
    @Id
    @Column(name = "NGANSACH_ID", nullable = false)
    private String nganSachID;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "NGAYBATDAU", nullable = false)
    private LocalDate ngayBatDau;
    @Column(name = "NGAYKETTHUC", nullable = false)
    private LocalDate ngayKetThuc;

    @ManyToOne
    @JoinColumn(name = "LOAINGANSACH_ID")
    private LoaiNganSach loaiNganSach;

    public String getNganSachID() {
        return nganSachID;
    }

    public void setNganSachID(String nganSachID) {
        this.nganSachID = nganSachID;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
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

    public LoaiNganSach getLoaiNganSach() {
        return loaiNganSach;
    }

    public void setLoaiNganSach(LoaiNganSach loaiNganSach) {
        this.loaiNganSach = loaiNganSach;
    }
}
