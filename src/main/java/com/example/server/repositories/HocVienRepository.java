package com.example.server.repositories;

import com.example.server.entities.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String> {
}
