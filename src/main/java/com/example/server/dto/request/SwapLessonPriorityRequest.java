package com.example.server.dto.request;

public class SwapLessonPriorityRequest {
    private String baiHoc1;
    private String baiHoc2;

    public String getBaiHoc1() {
        return baiHoc1;
    }

    public void setBaiHoc1(String baiHoc1) {
        this.baiHoc1 = baiHoc1;
    }

    public String getBaiHoc2() {
        return baiHoc2;
    }

    public void setBaiHoc2(String baiHoc2) {
        this.baiHoc2 = baiHoc2;
    }
}
