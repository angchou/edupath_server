package com.example.server.repositories;

import com.example.server.entities.ChinhSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ChinhSachRepository extends JpaRepository<ChinhSach, String> {
    List<ChinhSach> findByLoaiKHAndThoiHanGreaterThanEqual(Integer loaiKH, LocalDate thoiHan);
}
