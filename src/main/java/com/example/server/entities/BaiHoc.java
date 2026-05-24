package com.example.server.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BAIHOC")
public class BaiHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BAIHOC_ID", nullable = false)
    private String baiHocID;
    @Column(name = "STT", nullable = false)
    private Integer stt;
    @Column(name = "TENBAIHOC", nullable = false)
    private String tenBaiHoc;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID", nullable = false)
    private KhoaHoc khoaHoc;

    @OneToMany(mappedBy = "baiHoc", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaiNguyen> danhSachTaiNguyen;

    public String getBaiHocID() {
        return baiHocID;
    }

    public void setBaiHocID(String baiHocID) {
        this.baiHocID = baiHocID;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getTenBaiHoc() {
        return tenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        this.tenBaiHoc = tenBaiHoc;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }
}
