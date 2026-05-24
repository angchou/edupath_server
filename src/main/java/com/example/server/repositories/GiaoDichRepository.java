package com.example.server.repositories;

import com.example.server.entities.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, String> {
    List<GiaoDich> findByHocVien_UserID(String userID);

    @Query("SELECT COALESCE(SUM(gd.triGia), 0) FROM GiaoDich gd " +
            "JOIN gd.khoaHoc kh " +
            "WHERE kh.nguoiHuongDan.userID = :nguoiHuongDanID AND gd.trangThai = 1")
    BigDecimal sumTriGiaByNguoiHuongDan(@Param("nguoiHuongDanID") String nguoiHuongDanID);

    @Procedure(name = "GiaoDich.procCreateTransaction")
    Map<String, Object> callCreateTransactionProcedure(
            @Param("p_user_id") String userId,
            @Param("p_khoa_hoc_id") String khoaHocId,
            @Param("p_voucher_id") String voucherId,
            @Param("p_cong_gd") Integer congGd
    );

    List<GiaoDich> findByVoucher_VoucherID(String voucherID);
}
