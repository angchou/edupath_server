package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "THONGBAO")
public class ThongBao {
    @Id
    @Column(name = "THONGBAO_ID", nullable = false)
    private String thongBaoID;
    @Column(name = "TIEUDE", nullable = false)
    private String tieuDe;
    @Column(name = "NOIDUNG")
    private String noiDung;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;

    public String getThongBaoID() {
        return thongBaoID;
    }

    public void setThongBaoID(String thongBaoID) {
        this.thongBaoID = thongBaoID;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
