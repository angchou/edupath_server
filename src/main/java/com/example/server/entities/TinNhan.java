package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TINNHAN")
public class TinNhan {
    @Id
    @Column(name = "TINNHAN_ID", nullable = false)
    private String tinNhanID;
    @Column(name = "NOIDUNG", nullable = false)
    private String noiDung;
    @Column(name = "THOIGIANGUI")
    private LocalDate thoiGianGui;

    @ManyToOne
    @JoinColumn(name = "NGUOIGUI")
    private Users nguoiGui;
    @ManyToOne
    @JoinColumn(name = "CUOCTROCHUYEN_ID")
    private CuocTroChuyen cuocTroChuyen;

    public String getTinNhanID() {
        return tinNhanID;
    }

    public void setTinNhanID(String tinNhanID) {
        this.tinNhanID = tinNhanID;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(LocalDate thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public Users getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(Users nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public CuocTroChuyen getCuocTroChuyen() {
        return cuocTroChuyen;
    }

    public void setCuocTroChuyen(CuocTroChuyen cuocTroChuyen) {
        this.cuocTroChuyen = cuocTroChuyen;
    }
}
