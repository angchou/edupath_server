package com.example.server.dto.responses;

public class BlockResponse {

    private String URL;
    private Integer loaiTN;
    private String text;
    private String KhoaHoc_ID;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Integer getLoaiTN() {
        return loaiTN;
    }

    public void setLoaiTN(Integer loaiTN) {
        this.loaiTN = loaiTN;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKhoaHoc_ID() {
        return KhoaHoc_ID;
    }

    public void setKhoaHoc_ID(String khoaHoc_ID) {
        KhoaHoc_ID = khoaHoc_ID;
    }
}
