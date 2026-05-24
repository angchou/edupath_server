package com.example.server.dto.response;

import java.time.LocalDate;

public class ApplicationResponse {
    private String userID;
    private String hoTen;
    private String email;
    private String hoSoID;
    private LocalDate ngayTao;
    private String url;
    private Integer trangThai;

    public ApplicationResponse(String userID, String hoTen, String email, String hoSoID, LocalDate ngayTao, String url, Integer trangThai) {
        this.userID = userID;
        this.hoTen = hoTen;
        this.email = email;
        this.hoSoID = hoSoID;
        this.ngayTao = ngayTao;
        this.url = url;
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

    public String getHoSoID() {
        return hoSoID;
    }

    public void setHoSoID(String hoSoID) {
        this.hoSoID = hoSoID;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
