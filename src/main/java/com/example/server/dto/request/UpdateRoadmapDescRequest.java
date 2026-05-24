package com.example.server.dto.request;

public class UpdateRoadmapDescRequest {
    private String loTrinhID;
    private String moTa;

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
}
