package com.example.server.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @Column(name = "TICKET_ID", nullable = false)
    private String ticketID;
    @Column(name = "DOUUTIEN", nullable = false)
    private int doUuTien;
    @Column(name = "MOTA", nullable = false)
    private String moTa;
    @Column(name = "LOAITICKET", nullable = false)
    private int loaiTicket;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;
    @Column(name = "NGAYTAO")
    private LocalDate ngayTao;
    @Column(name = "NGAYHETHAN")
    private LocalDate ngayHetHan;

    @ManyToOne
    @JoinColumn(name = "NGUOITAO_ID")
    private Users nguoiTao;
    @ManyToOne
    @JoinColumn(name = "NHANVIENXULY_ID")
    private NhanVien nhanVienXuLy;
    @ManyToOne
    @JoinColumn(name = "NHANVIENCHUYENTIEP_ID")
    private NhanVien nhanVienChuyenTiep;

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public int getDoUuTien() {
        return doUuTien;
    }

    public void setDoUuTien(int doUuTien) {
        this.doUuTien = doUuTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getLoaiTicket() {
        return loaiTicket;
    }

    public void setLoaiTicket(int loaiTicket) {
        this.loaiTicket = loaiTicket;
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

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public Users getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(Users nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public NhanVien getNhanVienXuLy() {
        return nhanVienXuLy;
    }

    public void setNhanVienXuLy(NhanVien nhanVienXuLy) {
        this.nhanVienXuLy = nhanVienXuLy;
    }

    public NhanVien getNhanVienChuyenTiep() {
        return nhanVienChuyenTiep;
    }

    public void setNhanVienChuyenTiep(NhanVien nhanVienChuyenTiep) {
        this.nhanVienChuyenTiep = nhanVienChuyenTiep;
    }
}
