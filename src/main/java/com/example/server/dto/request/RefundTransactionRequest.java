package com.example.server.dto.request;

public class RefundTransactionRequest {
    private String giaoDichID;
    private String liDo;

    public String getGiaoDichID() {
        return giaoDichID;
    }

    public void setGiaoDichID(String giaoDichID) {
        this.giaoDichID = giaoDichID;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }
}
