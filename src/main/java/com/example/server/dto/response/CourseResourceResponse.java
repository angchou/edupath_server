package com.example.server.dto.response;

public class CourseResourceResponse {
    private String taiNguyenID;
    private String url;
    private int loaiTN;
    private int stt;
    private String text;

    public CourseResourceResponse(String taiNguyenID, String url, int loaiTN, int stt, String text) {
        this.taiNguyenID = taiNguyenID;
        this.url = url;
        this.loaiTN = loaiTN;
        this.stt = stt;
        this.text = text;
    }

    public String getTaiNguyenID() {
        return taiNguyenID;
    }

    public void setTaiNguyenID(String taiNguyenID) {
        this.taiNguyenID = taiNguyenID;
    }

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
