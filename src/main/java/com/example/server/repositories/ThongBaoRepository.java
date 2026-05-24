package com.example.server.repositories;

import com.example.server.entities.ThongBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, String> {
    List<ThongBao> findByUser_UserID(String userID);

    // Trong ThongBaoRepository.java
    @Modifying
    @Query("DELETE FROM ThongBao t WHERE t.user.userID = :userID")
    void deleteAllByUserID(String userID);
}
