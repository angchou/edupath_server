package com.example.server.dto.request;

public class CreateTransactionRequest {
    private int congGD;
    private String khoaHocID;
    private String voucherID;

    public int getCongGD() {
        return congGD;
    }

    public void setCongGD(int congGD) {
        this.congGD = congGD;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }
}
