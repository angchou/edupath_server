package com.example.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "HSDANGKYMENTOR")
public class HSDangKyMentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOSO_ID", nullable = false)
    private String hoSoID;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;
    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "HOCVIEN_ID")
    @JsonIgnore
    private HocVien hocVien;

    public String getHoSoID() {
        return hoSoID;
    }

    public void setHoSoID(String hoSoID) {
        this.hoSoID = hoSoID;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }
}
