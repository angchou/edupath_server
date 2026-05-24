package com.example.server.repositories;

import com.example.server.entities.HSDangKyMentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HSDangKyMentorRepository extends JpaRepository<HSDangKyMentor, String> {
    Optional<HSDangKyMentor> findByHocVien_UserID(String userID);
    List<HSDangKyMentor> findByTrangThai(Integer trangThai);
    boolean existsByHocVien_UserID(String UserID);
}
