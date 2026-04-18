package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TAINGUYEN")
public class TaiNguyen {
    @Id
    @Column(name = "TAINGUYEN_ID", nullable = false)
    private String taiNguyenID;
    @Column(name = "URL")
    private String url;
    @Column(name = "LOAITN", nullable = false)
    private int loaiTN;
    @Column(name = "STT", nullable = false)
    private int stt;
    @Column(name = "TEXT")
    private String text;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;

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

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
