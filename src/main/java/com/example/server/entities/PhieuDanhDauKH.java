package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PHIEUDANHDAUKH")
public class PhieuDanhDauKH {
    @Id
    @Column(name = "PHIEUDANHDAUKH_ID", nullable = false)
    private String phieuDanhDauID;
    @Column(name = "MOTA", nullable = false)
    private String moTa;
    @Column(name = "MUCDANHDAU", nullable = false)
    private int mucDanhDau;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;
    @ManyToOne
    @JoinColumn(name = "NHANVIENDANHDAU")
    private NhanVien nhanVien;
}
