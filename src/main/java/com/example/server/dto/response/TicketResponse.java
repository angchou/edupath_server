package com.example.server.dto.response;

import java.time.LocalDate;

public class TicketResponse {
    private String ticketID;
    private int doUuTien;
    private String moTa;
    private int loaiTicket;
    private int trangThai;
    private LocalDate ngayTao;
    private LocalDate ngayHetHan;
    private String nguoiTao;
    private String nhanVienXuLy;

    public TicketResponse(String ticketID, int doUuTien, String moTa, int loaiTicket, int trangThai, LocalDate ngayTao, LocalDate ngayHetHan, String nguoiTao, String nhanVienXuLy) {
        this.ticketID = ticketID;
        this.doUuTien = doUuTien;
        this.moTa = moTa;
        this.loaiTicket = loaiTicket;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.nguoiTao = nguoiTao;
        this.nhanVienXuLy = nhanVienXuLy;
    }

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

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNhanVienXuLy() {
        return nhanVienXuLy;
    }

    public void setNhanVienXuLy(String nhanVienXuLy) {
        this.nhanVienXuLy = nhanVienXuLy;
    }
}
