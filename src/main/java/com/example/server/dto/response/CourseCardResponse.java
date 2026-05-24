package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CourseCardResponse {
    private String khoaHocID;
    private String tenKH;
    private String moTa;
    private int slhv;
    private LocalDate ngayTao;
    private BigDecimal mucPhi;
    private String url;
    private Integer tinhTrang;
    private Integer loaiKH;
    private Integer thoiHan;
    private boolean daDanhGia;
    private Integer slhvHienTai;

    // nguoi huong dan
    private String userID;
    private String hoTen;

    public CourseCardResponse(String khoaHocID, String tenKH, String moTa, int slhv, LocalDate ngayTao, BigDecimal mucPhi, String url, Integer tinhTrang, Integer loaiKH, Integer thoiHan, String userID, String hoTen) {
        this.khoaHocID = khoaHocID;
        this.tenKH = tenKH;
        this.moTa = moTa;
        this.slhv = slhv;
        this.ngayTao = ngayTao;
        this.mucPhi = mucPhi;
        this.url = url;
        this.tinhTrang = tinhTrang;
        this.loaiKH = loaiKH;
        this.thoiHan = thoiHan;
        this.userID = userID;
        this.hoTen = hoTen;
    }

    private boolean duocDanhGia;

    public CourseCardResponse(String khoaHocID, String tenKH, String moTa, int slhv, LocalDate ngayTao, BigDecimal mucPhi, String url, Integer tinhTrang, Integer loaiKH, Integer thoiHan, boolean daDanhGia, String userID, String hoTen, boolean duocDanhGia) {
        this.khoaHocID = khoaHocID;
        this.tenKH = tenKH;
        this.moTa = moTa;
        this.slhv = slhv;
        this.ngayTao = ngayTao;
        this.mucPhi = mucPhi;
        this.url = url;
        this.tinhTrang = tinhTrang;
        this.loaiKH = loaiKH;
        this.thoiHan = thoiHan;
        this.daDanhGia = daDanhGia;
        this.userID = userID;
        this.hoTen = hoTen;
        this.duocDanhGia = duocDanhGia;
    }

    public CourseCardResponse(String khoaHocID, String tenKH, String moTa, int slhv, LocalDate ngayTao, BigDecimal mucPhi, String url, Integer tinhTrang, Integer loaiKH, Integer thoiHan, boolean daDanhGia, String userID, String hoTen, Integer slhvHienTai) {
        this.khoaHocID = khoaHocID;
        this.tenKH = tenKH;
        this.moTa = moTa;
        this.slhv = slhv;
        this.ngayTao = ngayTao;
        this.mucPhi = mucPhi;
        this.url = url;
        this.tinhTrang = tinhTrang;
        this.loaiKH = loaiKH;
        this.thoiHan = thoiHan;
        this.daDanhGia = daDanhGia;
        this.userID = userID;
        this.hoTen = hoTen;
        this.slhvHienTai = slhvHienTai;
    }

    public boolean isDuocDanhGia() {
        return duocDanhGia;
    }

    public void setDuocDanhGia(boolean duocDanhGia) {
        this.duocDanhGia = duocDanhGia;
    }

    public Integer getSlhvHienTai() {
        return slhvHienTai;
    }

    public void setSlhvHienTai(Integer slhvHienTai) {
        this.slhvHienTai = slhvHienTai;
    }

    public boolean isDaDanhGia() {
        return daDanhGia;
    }

    public void setDaDanhGia(boolean daDanhGia) {
        this.daDanhGia = daDanhGia;
    }

    public Integer getThoiHan() {
        return thoiHan;
    }

    public void setThoiHan(Integer thoiHan) {
        this.thoiHan = thoiHan;
    }

    public Integer getLoaiKH() {
        return loaiKH;
    }

    public void setLoaiKH(Integer loaiKH) {
        this.loaiKH = loaiKH;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public BigDecimal getMucPhi() {
        return mucPhi;
    }

    public void setMucPhi(BigDecimal mucPhi) {
        this.mucPhi = mucPhi;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSlhv() {
        return slhv;
    }

    public void setSlhv(int slhv) {
        this.slhv = slhv;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
