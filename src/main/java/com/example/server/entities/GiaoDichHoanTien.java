package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "GIAODICHHOANTIEN")
public class GiaoDichHoanTien {
    @Id
    @Column(name = "HOANTIEN_ID", nullable = false)
    private String hoanTienID;
    @Column(name = "TRIGIAHT", nullable = false)
    private BigDecimal triGiaHT;
    @Column(name = "NGAYHT")
    private LocalDate ngayHT;
    @Column(name = "LOAIHT", nullable = false)
    private int loaiHT;
    @Column(name = "LIDO", nullable = false)
    private String liDo;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;

    @OneToOne
    @MapsId
    @JoinColumn(name = "GIAODICH_ID")
    private GiaoDich giaoDich;

    public String getHoanTienID() {
        return hoanTienID;
    }

    public void setHoanTienID(String hoanTienID) {
        this.hoanTienID = hoanTienID;
    }

    public BigDecimal getTriGiaHT() {
        return triGiaHT;
    }

    public void setTriGiaHT(BigDecimal triGiaHT) {
        this.triGiaHT = triGiaHT;
    }

    public LocalDate getNgayHT() {
        return ngayHT;
    }

    public void setNgayHT(LocalDate ngayHT) {
        this.ngayHT = ngayHT;
    }

    public int getLoaiHT() {
        return loaiHT;
    }

    public void setLoaiHT(int loaiHT) {
        this.loaiHT = loaiHT;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public GiaoDich getGiaoDich() {
        return giaoDich;
    }

    public void setGiaoDich(GiaoDich giaoDich) {
        this.giaoDich = giaoDich;
    }
}
