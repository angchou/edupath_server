package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerResponse {
    private String userID;
    private String hoTen;
    private String email;
    private LocalDate ngayTao;
    private String roleName;
    private Integer trangThai;

    private String quocGiaDuHoc;
    private BigDecimal gpa;
    private String nganhHoc;

    public CustomerResponse(String userID, String hoTen, String email, LocalDate ngayTao, String roleName, Integer trangThai, String quocGiaDuHoc, BigDecimal gpa, String nganhHoc) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.ngayTao = ngayTao;
        this.roleName = roleName;
        this.trangThai = trangThai;
        this.quocGiaDuHoc = quocGiaDuHoc;
        this.gpa = gpa;
        this.nganhHoc = nganhHoc;
    }

    private BigDecimal doanhThu;
    private BigDecimal trungBinhDanhGia;

    public CustomerResponse(String userID, String hoTen, String email, LocalDate ngayTao, String roleName, Integer trangThai, BigDecimal doanhThu, BigDecimal trungBinhDanhGia) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.ngayTao = ngayTao;
        this.roleName = roleName;
        this.trangThai = trangThai;
        this.doanhThu = doanhThu;
        this.trungBinhDanhGia = trungBinhDanhGia;
    }

    public CustomerResponse(String userID, String hoTen, String email, LocalDate ngayTao, String roleName, Integer trangThai) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.ngayTao = ngayTao;
        this.roleName = roleName;
        this.trangThai = trangThai;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
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

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getQuocGiaDuHoc() {
        return quocGiaDuHoc;
    }

    public void setQuocGiaDuHoc(String quocGiaDuHoc) {
        this.quocGiaDuHoc = quocGiaDuHoc;
    }

    public BigDecimal getGpa() {
        return gpa;
    }

    public void setGpa(BigDecimal gpa) {
        this.gpa = gpa;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public BigDecimal getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(BigDecimal doanhThu) {
        this.doanhThu = doanhThu;
    }

    public BigDecimal getTrungBinhDanhGia() {
        return trungBinhDanhGia;
    }

    public void setTrungBinhDanhGia(BigDecimal trungBinhDanhGia) {
        this.trungBinhDanhGia = trungBinhDanhGia;
    }
}
