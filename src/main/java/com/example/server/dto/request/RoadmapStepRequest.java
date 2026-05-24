package com.example.server.dto.request;

public class RoadmapStepRequest {
    private String dauViecID; // null -> new --- not null -> replace with the old one
    private String tenDauViec;
    private int stt;
    private String moTa;

    public RoadmapStepRequest(String dauViecID, String tenDauViec, int stt, String moTa) {
        this.dauViecID = dauViecID;
        this.tenDauViec = tenDauViec;
        this.stt = stt;
        this.moTa = moTa;
    }

    public String getDauViecID() {
        return dauViecID;
    }

    public void setDauViecID(String dauViecID) {
        this.dauViecID = dauViecID;
    }

    public String getTenDauViec() {
        return tenDauViec;
    }

    public void setTenDauViec(String tenDauViec) {
        this.tenDauViec = tenDauViec;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
