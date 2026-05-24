package com.example.server.repositories;

import com.example.server.entities.CuocTroChuyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CuocTroChuyenRepository extends JpaRepository<CuocTroChuyen, String> {
    @Query("SELECT c FROM CuocTroChuyen c WHERE " +
            "(c.nguoiKhoiTao.userID = :user1 AND c.nguoiNhan.userID = :user2) OR " +
            "(c.nguoiKhoiTao.userID = :user2 AND c.nguoiNhan.userID = :user1)")
    Optional<CuocTroChuyen> findBetweenUsers(@Param("user1") String userID1, @Param("user2") String userID2);
    List<CuocTroChuyen> findByNguoiNhan_UserID(String userID);

    @Query("SELECT c FROM CuocTroChuyen c WHERE " +
            "(c.nguoiNhan.userID = :userID AND c.nguoiKhoiTao.userID IN :hocVienIDs) OR " +
            "(c.nguoiKhoiTao.userID = :userID AND c.nguoiNhan.userID IN :hocVienIDs)")
    List<CuocTroChuyen> findConversationsWithActiveHocVien(
            @Param("userID") String userID,
            @Param("hocVienIDs") List<String> hocVienIDs
    );
}
