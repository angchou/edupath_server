package com.example.server.dto.request;

public class UpdateLessonRequest {
    private String baiHocID;
    private String tenBaiHoc;

    public String getBaiHocID() {
        return baiHocID;
    }

    public void setBaiHocID(String baiHocID) {
        this.baiHocID = baiHocID;
    }

    public String getTenBaiHoc() {
        return tenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        this.tenBaiHoc = tenBaiHoc;
    }
}
