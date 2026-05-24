package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private String userID;
    @Column(name = "CHUCVU", nullable = false)
    private String chucVu;
    @Column(name = "LUONGCOBAN", nullable = false)
    private BigDecimal luongCoBan;
    @Column(name = "LUONGPHUCAP", nullable = false)
    private BigDecimal luongPhuCap;

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    private Users user;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public BigDecimal getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(BigDecimal luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public BigDecimal getLuongPhuCap() {
        return luongPhuCap;
    }

    public void setLuongPhuCap(BigDecimal luongPhuCap) {
        this.luongPhuCap = luongPhuCap;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
