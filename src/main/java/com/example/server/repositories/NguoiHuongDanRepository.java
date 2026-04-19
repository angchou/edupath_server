package com.example.server.repositories;

import com.example.server.entities.NguoiHuongDan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiHuongDanRepository extends JpaRepository<NguoiHuongDan, String> {
}
