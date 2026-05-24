package com.example.server.dto.response;

public class CourseMarkResponse {
    private String phieuDanhDauID;
    private String moTa;
    private Integer mucDanhDau;
    private String nhanVienID;

    public CourseMarkResponse(String phieuDanhDauID, String moTa, Integer mucDanhDau, String nhanVienID) {
        this.phieuDanhDauID = phieuDanhDauID;
        this.moTa = moTa;
        this.mucDanhDau = mucDanhDau;
        this.nhanVienID = nhanVienID;
    }

    public String getPhieuDanhDauID() {
        return phieuDanhDauID;
    }

    public void setPhieuDanhDauID(String phieuDanhDauID) {
        this.phieuDanhDauID = phieuDanhDauID;
    }

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

    public String getNhanVienID() {
        return nhanVienID;
    }

    public void setNhanVienID(String nhanVienID) {
        this.nhanVienID = nhanVienID;
    }
}
