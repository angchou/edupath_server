package com.example.server.dto.response;

public class BudgetTypeResponse {
    private String loaiNganSachID;
    private String tenLNS;

    public BudgetTypeResponse(String loaiNganSachID, String tenLNS) {
        this.loaiNganSachID = loaiNganSachID;
        this.tenLNS = tenLNS;
    }

    public String getLoaiNganSachID() {
        return loaiNganSachID;
    }

    public void setLoaiNganSachID(String loaiNganSachID) {
        this.loaiNganSachID = loaiNganSachID;
    }

    public String getTenLNS() {
        return tenLNS;
    }

    public void setTenLNS(String tenLNS) {
        this.tenLNS = tenLNS;
    }
}
