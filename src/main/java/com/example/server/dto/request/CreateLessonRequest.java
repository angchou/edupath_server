package com.example.server.dto.request;

public class CreateLessonRequest {
    private String tenBaiHoc;
    private String khoaHocID;

    public String getTenBaiHoc() {
        return tenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        this.tenBaiHoc = tenBaiHoc;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }
}
