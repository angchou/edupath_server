package com.example.server.dto.request;

public class CreateMarkCourseRequest {
    private String moTa;
    private Integer mucDanhDau;
    private String khoaHocID;

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getMucDanhDau() {
        return mucDanhDau;
    }

    public void setMucDanhDau(Integer mucDanhDau) {
        this.mucDanhDau = mucDanhDau;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }
}
