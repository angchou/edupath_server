package com.example.server.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LOAINGANSACH")
public class LoaiNganSach {
    @Id
    @Column(name = "LOAINGANSACH_ID", nullable = false)
    private String loaiNganSachID;
    @Column(name = "TENLNS", nullable = false)
    private String tenLNS;

    public String getLoaiNganSachID() {
        return loaiNganSachID;
    }

    public void setLoaiNganSachID(String loaiNganSachID) {
        this.loaiNganSachID = loaiNganSachID;
    }

    public String getTenLNS() {
        return tenLNS;
    }

    public void setTenLNS(String tenLNS) {
        this.tenLNS = tenLNS;
    }
}
