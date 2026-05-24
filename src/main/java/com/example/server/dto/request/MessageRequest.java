package com.example.server.dto.request;

import java.time.LocalDateTime;

public class MessageRequest {
    private String cuocTroChuyenID;
    private String noiDung;
    private String nguoiNhan;

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getCuocTroChuyenID() {
        return cuocTroChuyenID;
    }

    public void setCuocTroChuyenID(String cuocTroChuyenID) {
        this.cuocTroChuyenID = cuocTroChuyenID;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

}
