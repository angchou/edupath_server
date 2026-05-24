package com.example.server.dto.request;

import java.util.List;

public class EditRoadmapRequest {
    private String loTrinhID;
    private List<RoadmapStepRequest> danhSachDauViec;

    public String getLoTrinhID() {
        return loTrinhID;
    }

    public void setLoTrinhID(String loTrinhID) {
        this.loTrinhID = loTrinhID;
    }

    public List<RoadmapStepRequest> getDanhSachDauViec() {
        return danhSachDauViec;
    }

    public void setDanhSachDauViec(List<RoadmapStepRequest> danhSachDauViec) {
        this.danhSachDauViec = danhSachDauViec;
    }
}
