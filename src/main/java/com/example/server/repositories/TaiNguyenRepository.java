package com.example.server.repositories;

import com.example.server.entities.TaiNguyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiNguyenRepository extends JpaRepository<TaiNguyen, String> {
    List<TaiNguyen> findByKhoaHoc_KhoaHocID(String khoaHocID);
}
