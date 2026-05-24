package com.example.server.repositories;

import com.example.server.entities.PhieuDanhDauKH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhieuDanhDauKHRepository extends JpaRepository<PhieuDanhDauKH, String> {
    List<PhieuDanhDauKH> findByKhoaHoc_KhoaHocID(String khoaHocID);
}
