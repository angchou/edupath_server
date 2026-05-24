package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "CUOCTROCHUYEN")
public class CuocTroChuyen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUOCTROCHUYEN_ID", nullable = false)
    private String cuocTroChuyenID;
    @Column(name = "THOIGIANTAO")
    private LocalDate thoiGianTao;

    @ManyToOne
    @JoinColumn(name = "NGUOIKHOITAO")
    private Users nguoiKhoiTao;
    @ManyToOne
    @JoinColumn(name = "NGUOINHAN")
    private Users nguoiNhan;

    public String getCuocTroChuyenID() {
        return cuocTroChuyenID;
    }

    public void setCuocTroChuyenID(String cuocTroChuyenID) {
        this.cuocTroChuyenID = cuocTroChuyenID;
    }

    public LocalDate getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDate thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Users getNguoiKhoiTao() {
        return nguoiKhoiTao;
    }

    public void setNguoiKhoiTao(Users nguoiKhoiTao) {
        this.nguoiKhoiTao = nguoiKhoiTao;
    }

    public Users getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(Users nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }
}
