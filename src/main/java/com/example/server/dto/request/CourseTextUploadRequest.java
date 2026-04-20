package com.example.server.dto.request;

public class CourseTextUploadRequest {
    private String url;
    private int loaiTN;
    private int stt;
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

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
