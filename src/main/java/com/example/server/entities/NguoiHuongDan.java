package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "NGUOIHUONGDAN")
public class NguoiHuongDan {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userID;
    @Column(name = "TRUNGBINHDANHGIA")
    private BigDecimal trungBinhDanhGia;
    @Column(name = "DOANHTHU")
    private BigDecimal doanhThu;

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

    public BigDecimal getTrungBinhDanhGia() {
        return trungBinhDanhGia;
    }

    public void setTrungBinhDanhGia(BigDecimal trungBinhDanhGia) {
        this.trungBinhDanhGia = trungBinhDanhGia;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
