package com.example.server.dto.response;

import com.example.server.entities.TinNhan;

import java.time.LocalDateTime;

public class MessageResponse {
    private String tinNhanID;
    private String cuocTroChuyenID;
    private String nguoiGui;
    private LocalDateTime thoiGianGui;
    private String noiDung;

    public MessageResponse(String tinNhanID, String cuocTroChuyenID, String nguoiGui, LocalDateTime thoiGianGui, String noiDung) {
        this.tinNhanID = tinNhanID;
        this.cuocTroChuyenID = cuocTroChuyenID;
        this.nguoiGui = nguoiGui;
        this.thoiGianGui = thoiGianGui;
        this.noiDung = noiDung;
    }

    public String getTinNhanID() {
        return tinNhanID;
    }

    public void setTinNhanID(String tinNhanID) {
        this.tinNhanID = tinNhanID;
    }

    public String getCuocTroChuyenID() {
        return cuocTroChuyenID;
    }

    public void setCuocTroChuyenID(String cuocTroChuyenID) {
        this.cuocTroChuyenID = cuocTroChuyenID;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public LocalDateTime getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(LocalDateTime thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
