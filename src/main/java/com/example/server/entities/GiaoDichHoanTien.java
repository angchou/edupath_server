package com.example.server.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "GIAODICHHOANTIEN")
public class GiaoDichHoanTien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOANTIEN_ID")
    private String hoanTienID;
    @Column(name = "NGAYHT")
    private LocalDate ngayHT;
    @Column(name = "NGAYTAO", nullable = false)
    private LocalDateTime ngayTao;
    @Column(name = "LIDO", nullable = false)
    private String liDo;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;

    @OneToOne
    @JoinColumn(name = "GIAODICH_ID")
    private GiaoDich giaoDich;
    @ManyToOne
    @JoinColumn(name = "NHANVIENXULY_ID")
    private NhanVien nhanVienXuLy;

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getHoanTienID() {
        return hoanTienID;
    }

    public void setHoanTienID(String hoanTienID) {
        this.hoanTienID = hoanTienID;
    }

    public LocalDate getNgayHT() {
        return ngayHT;
    }

    public void setNgayHT(LocalDate ngayHT) {
        this.ngayHT = ngayHT;
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

    public NhanVien getNhanVienXuLy() {
        return nhanVienXuLy;
    }

    public void setNhanVienXuLy(NhanVien nhanVienXuLy) {
        this.nhanVienXuLy = nhanVienXuLy;
    }
}
