package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeResponse {
    private String userID;
    private String hoTen;
    private String email;
    private String password;
    private Integer roleID;
    private LocalDate ngayTao;
    private Integer trangThai;

    private String chucVu;
    private BigDecimal luongCoBan;
    private BigDecimal luongPhuCap;

    public EmployeeResponse(String userID, String hoTen, String email, String password, Integer roleID, LocalDate ngayTao, Integer trangThai, String chucVu, BigDecimal luongCoBan, BigDecimal luongPhuCap) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.luongPhuCap = luongPhuCap;
    }

    private LocalDate ngayTraLuongCuoiCung;

    public EmployeeResponse(String userID, String hoTen, String email, String password, Integer roleID, LocalDate ngayTao, Integer trangThai, String chucVu, BigDecimal luongCoBan, BigDecimal luongPhuCap, LocalDate ngayTraLuongCuoiCung) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.password = password;
        this.roleID = roleID;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
        this.chucVu = chucVu;
        this.luongCoBan = luongCoBan;
        this.luongPhuCap = luongPhuCap;
        this.ngayTraLuongCuoiCung = ngayTraLuongCuoiCung;
    }

    public LocalDate getNgayTraLuongCuoiCung() {
        return ngayTraLuongCuoiCung;
    }

    public void setNgayTraLuongCuoiCung(LocalDate ngayTraLuongCuoiCung) {
        this.ngayTraLuongCuoiCung = ngayTraLuongCuoiCung;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
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
}
