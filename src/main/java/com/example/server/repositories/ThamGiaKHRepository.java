package com.example.server.repositories;

import com.example.server.entities.ThamGiaKH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThamGiaKHRepository extends JpaRepository<ThamGiaKH, String> {
    List<ThamGiaKH> findByHocVien_UserID(String userID);
}
