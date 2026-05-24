package com.example.server.dto.response;

import com.example.server.dto.request.RoadmapStepRequest;

import java.util.List;

public class PublicRoadmapResponse {
    private String loTrinhID;
    private String moTa;
    private int trangThai;
    private String userID;
    private String hoTen;
    private String email;
    private List<RoadmapStepRequest> danhSachDauViec;

    public String getLoTrinhID() {
        return loTrinhID;
    }

    public void setLoTrinhID(String loTrinhID) {
        this.loTrinhID = loTrinhID;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
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

    public List<RoadmapStepRequest> getDanhSachDauViec() {
        return danhSachDauViec;
    }

    public void setDanhSachDauViec(List<RoadmapStepRequest> danhSachDauViec) {
        this.danhSachDauViec = danhSachDauViec;
    }
}
