package com.example.server.repositories;

import com.example.server.entities.PhieuDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDanhGiaRepository extends JpaRepository<PhieuDanhGia, String> {
    List<PhieuDanhGia> findByKhoaHoc_KhoaHocID(String khoaHocID);
    PhieuDanhGia findByKhoaHoc_KhoaHocIDAndHocVien_UserID(String khoaHocID, String userID);
    boolean existsByKhoaHoc_KhoaHocIDAndHocVien_UserID(String khoaHocID, String userID);
}
