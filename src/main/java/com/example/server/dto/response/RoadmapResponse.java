package com.example.server.dto.response;

import com.example.server.dto.request.RoadmapStepRequest;

import java.util.List;

public class RoadmapResponse {
    private String loTrinhID;
    private int trangThai;
    private String moTa;
    private List<RoadmapStepRequest> danhSachDauViec;

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoTrinhID() {
        return loTrinhID;
    }

    public void setLoTrinhID(String loTrinhID) {
        this.loTrinhID = loTrinhID;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<RoadmapStepRequest> getDanhSachDauViec() {
        return danhSachDauViec;
    }

    public void setDanhSachDauViec(List<RoadmapStepRequest> danhSachDauViec) {
        this.danhSachDauViec = danhSachDauViec;
    }
}
