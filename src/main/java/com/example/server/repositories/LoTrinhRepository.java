package com.example.server.repositories;

import com.example.server.entities.LoTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoTrinhRepository extends JpaRepository<LoTrinh, String> {
    Optional<LoTrinh> findByNguoiHuongDan_UserID(String userID);
    Optional<LoTrinh> findByHocVien_UserID(String userID);

    List<LoTrinh> findByTrangThai(int trangThai);
}
