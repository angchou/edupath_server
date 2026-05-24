package com.example.server.repositories;

import com.example.server.entities.GiaoDichHoanTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiaoDichHoanTienRepository extends JpaRepository<GiaoDichHoanTien, String> {
    boolean existsByGiaoDich_GiaoDichID(String giaoDichID);
    List<GiaoDichHoanTien> findByTrangThai(Integer trangThai);
}
