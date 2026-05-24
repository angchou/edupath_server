package com.example.server.dto.response;

public class LessonResponse {
    private String baiHocID;
    private String tenBaiHoc;
    private Integer stt;

    public LessonResponse(String baiHocID, String tenBaiHoc, Integer stt) {
        this.baiHocID = baiHocID;
        this.tenBaiHoc = tenBaiHoc;
        this.stt = stt;
    }

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

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }
}
