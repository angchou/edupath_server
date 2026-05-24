package com.example.server.dto.response;

import java.time.LocalDate;

public class RatingResponse {
    private String phieuDanhGiaID;
    private String chiTiet;
    private int diemDanhGia;
    private LocalDate ngayTao;
    private String hocVienID;
    private String hoTen;
    private String email;

    public RatingResponse(String phieuDanhGiaID, String chiTiet, int diemDanhGia, LocalDate ngayTao, String hocVienID, String hoTen, String email) {
        this.phieuDanhGiaID = phieuDanhGiaID;
        this.chiTiet = chiTiet;
        this.diemDanhGia = diemDanhGia;
        this.ngayTao = ngayTao;
        this.hocVienID = hocVienID;
        this.hoTen = hoTen;
        this.email = email;
    }

    public RatingResponse(String phieuDanhGiaID, String chiTiet, int diemDanhGia, LocalDate ngayTao) {
        this.phieuDanhGiaID = phieuDanhGiaID;
        this.chiTiet = chiTiet;
        this.diemDanhGia = diemDanhGia;
        this.ngayTao = ngayTao;
    }

    public String getPhieuDanhGiaID() {
        return phieuDanhGiaID;
    }

    public void setPhieuDanhGiaID(String phieuDanhGiaID) {
        this.phieuDanhGiaID = phieuDanhGiaID;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }

    public int getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setDiemDanhGia(int diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getHocVienID() {
        return hocVienID;
    }

    public void setHocVienID(String hocVienID) {
        this.hocVienID = hocVienID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
