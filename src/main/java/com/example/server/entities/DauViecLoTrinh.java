package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DAUVIECLOTRINH")
public class DauViecLoTrinh {
    @Id
    @Column(name = "DAUVIEC_ID", nullable = false)
    private String dauViecID;
    @Column(name = "TENDAUVIEC", nullable = false)
    private String tenDauViec;
    @Column(name = "STT", nullable = false)
    private int stt;
    @Column(name = "MOTA")
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "LOTRINH_ID")
    private LoTrinh loTrinh;

    public String getDauViecID() {
        return dauViecID;
    }

    public void setDauViecID(String dauViecID) {
        this.dauViecID = dauViecID;
    }

    public String getTenDauViec() {
        return tenDauViec;
    }

    public void setTenDauViec(String tenDauViec) {
        this.tenDauViec = tenDauViec;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LoTrinh getLoTrinh() {
        return loTrinh;
    }

    public void setLoTrinh(LoTrinh loTrinh) {
        this.loTrinh = loTrinh;
    }
}
