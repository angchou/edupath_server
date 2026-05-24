package com.example.server.dto.request;

public class CreateBlockRequest {
    private String baiHocID;

    private String url;
    private int loaiTN;
    private String text;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(int loaiTN) {
        this.loaiTN = loaiTN;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBaiHocID() {
        return baiHocID;
    }

    public void setBaiHocID(String baiHocID) {
        this.baiHocID = baiHocID;
    }
}
