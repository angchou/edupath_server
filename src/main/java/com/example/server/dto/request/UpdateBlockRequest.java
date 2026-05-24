package com.example.server.dto.request;

public class UpdateBlockRequest {
    private String taiNguyenID;
    private String url;
    private Integer loaiTN;
    private String text;

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
}
