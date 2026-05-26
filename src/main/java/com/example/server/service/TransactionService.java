package com.example.server.service;

import com.example.server.dto.request.CreateTransactionRequest;
import com.example.server.dto.request.RefundTransactionRequest;
import com.example.server.dto.request.CreateWithdrawRequest;
import com.example.server.dto.response.RevenueResponse;
import com.example.server.dto.response.TransactionResponse;
import com.example.server.dto.response.WithdrawResponse;
import com.example.server.entities.*;
import com.example.server.repositories.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TransactionService {

    @Autowired
    private GiaoDichRepository giaoDichRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private VoucherRepository voucherRepository;
    @Autowired
    private ThamGiaKHRepository thamGiaKHRepository;
    @Autowired
    private ChiPhiKMRepository chiPhiKMRepository;
    @Autowired
    private PhiSanRepository phiSanRepository;
    @Autowired
    private ChinhSachRepository chinhSachRepository;
    @Autowired
    private GiaoDichHoanTienRepository giaoDichHoanTienRepository;
    @Autowired
    private PhieuRutTienRepository phieuRutTienRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private NotificationService notificationService;

    @PersistenceContext
    private EntityManager entityManager;

    public List<TransactionResponse> getMyTransactions() {
        String userID = Objects.requireNonNull(
                SecurityContextHolder.getContext().getAuthentication()
        ).getName();
        List<GiaoDich> danhSachGiaoDich = giaoDichRepository.findByHocVien_UserID(userID);
        List<TransactionResponse> danhSach = new ArrayList<>();

        for (GiaoDich giaoDich : danhSachGiaoDich) {
            TransactionResponse response = new TransactionResponse();
            response.setGiaoDichID(giaoDich.getGiaoDichID());
            response.setGiaGoc(giaoDich.getGiaGoc());
            response.setTriGia(giaoDich.getTriGia());
            response.setNgayGD(giaoDich.getNgayGD());
            response.setCongGD(giaoDich.getCongGD());
            response.setTrangThai(giaoDich.getTrangThai());
            if (giaoDich.getVoucher() == null) {
                response.setVoucherID(null);
                response.setMaApDung(null);
            } else {
                response.setVoucherID(giaoDich.getVoucher().getVoucherID());
                response.setMaApDung(giaoDich.getVoucher().getMaApDung());
            }
            response.setKhoaHocID(giaoDich.getKhoaHoc().getKhoaHocID());
            response.setRefunded(giaoDichHoanTienRepository.existsByGiaoDich_GiaoDichID(giaoDich.getGiaoDichID()));

            danhSach.add(response);
        }

        return danhSach;
    }

    public List<TransactionResponse> getAllTransactions() {
        List<GiaoDich> danhSachGiaoDich = giaoDichRepository.findAll();
        List<TransactionResponse> danhSach = new ArrayList<>();

        for (GiaoDich giaoDich : danhSachGiaoDich) {
            TransactionResponse response = new TransactionResponse();
            response.setGiaoDichID(giaoDich.getGiaoDichID());
            response.setGiaGoc(giaoDich.getGiaGoc());
            response.setTriGia(giaoDich.getTriGia());
            response.setNgayGD(giaoDich.getNgayGD());
            response.setCongGD(giaoDich.getCongGD());
            response.setTrangThai(giaoDich.getTrangThai());
            if (giaoDich.getVoucher() == null) {
                response.setVoucherID(null);
                response.setMaApDung(null);
            } else {
                response.setVoucherID(giaoDich.getVoucher().getVoucherID());
                response.setMaApDung(giaoDich.getVoucher().getMaApDung());
            }
            response.setKhoaHocID(giaoDich.getKhoaHoc().getKhoaHocID());
            response.setRefunded(giaoDichHoanTienRepository.existsByGiaoDich_GiaoDichID(giaoDich.getGiaoDichID()));

            danhSach.add(response);
        }

        return danhSach;
    }

    public List<TransactionResponse> getTransactionsByVoucher(String voucherID) {
        List<GiaoDich> danhSach = giaoDichRepository.findByVoucher_VoucherID(voucherID);
        List<TransactionResponse> responseList = new ArrayList<>();

        for (GiaoDich gd : danhSach) {
            TransactionResponse res = new TransactionResponse();
            res.setGiaoDichID(gd.getGiaoDichID());
            res.setGiaGoc(gd.getGiaGoc());
            res.setTriGia(gd.getTriGia());
            res.setNgayGD(gd.getNgayGD());
            res.setCongGD(gd.getCongGD());
            res.setTrangThai(gd.getTrangThai());

            if (gd.getVoucher() == null) {
                res.setVoucherID(null);
                res.setMaApDung(null);
            } else {
                res.setVoucherID(gd.getVoucher().getVoucherID());
                res.setMaApDung(gd.getVoucher().getMaApDung());
            }

            res.setKhoaHocID(gd.getKhoaHoc().getKhoaHocID());
            res.setKhoaHocID(gd.getKhoaHoc().getKhoaHocID());
            res.setUserID(gd.getHocVien().getUserID());

            responseList.add(res);
        }

        return responseList;
    }

    public List<TransactionResponse> getRefundByStatus(Integer trangThai) {
        List<GiaoDichHoanTien> danhSach = giaoDichHoanTienRepository.findByTrangThai(trangThai);
        List<TransactionResponse> danhSachHoanTien = new ArrayList<>();

        for (GiaoDichHoanTien ht : danhSach) {
            TransactionResponse res = new TransactionResponse();
            res.setGiaoDichID(ht.getGiaoDich().getGiaoDichID());
            res.setGiaGoc(ht.getGiaoDich().getGiaGoc());
            res.setTriGia(ht.getGiaoDich().getTriGia());
            res.setNgayGD(ht.getGiaoDich().getNgayGD());
            res.setCongGD(ht.getGiaoDich().getCongGD());
            res.setTrangThai(ht.getGiaoDich().getTrangThai());
            if (ht.getGiaoDich().getVoucher() == null) {
                res.setVoucherID(null);
                res.setMaApDung(null);
            } else {
                res.setVoucherID(ht.getGiaoDich().getVoucher().getVoucherID());
                res.setMaApDung(ht.getGiaoDich().getVoucher().getMaApDung());
            }
            res.setKhoaHocID(ht.getGiaoDich().getKhoaHoc().getKhoaHocID());
            res.setHoanTienID(ht.getHoanTienID());
            res.setNgayHT(ht.getNgayHT());
            res.setLiDo(ht.getLiDo());
            res.setNgayTao(ht.getNgayTao());

            phiSanRepository.findByGiaoDich_GiaoDichID(ht.getGiaoDich().getGiaoDichID()).ifPresent(phiSan -> res.setPhiSan(phiSan.getSoTienPhiSan()));

            danhSachHoanTien.add(res);
        }

        return danhSachHoanTien;
    }

    public RevenueResponse getMentorRevenue() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        Query queryKhaDung = entityManager.createNativeQuery("SELECT func_TinhSoDuKhaDung(:userID) FROM dual");
        queryKhaDung.setParameter("userID", userID);
        Object result = queryKhaDung.getSingleResult();
        BigDecimal soDuKhaDung = (result != null) ? new BigDecimal(result.toString()) : BigDecimal.ZERO;

        BigDecimal tongDoanhThu = giaoDichRepository.sumTriGiaByNguoiHuongDan(userID)
                .subtract(phiSanRepository.sumSoTienPhiSanByNguoiHuongDan(userID));

        BigDecimal daRutThanhCong = phieuRutTienRepository.sumSoTienRutByUserID(userID);

        List<PhieuRutTien> danhSachRutTien = phieuRutTienRepository.findByNguoiHuongDan_UserID(userID);

        return new RevenueResponse(
                tongDoanhThu,
                daRutThanhCong,
                soDuKhaDung,
                danhSachRutTien.stream().map(rt -> new WithdrawResponse(
                        rt.getRutTienID(),
                        rt.getSoTienRut(),
                        rt.getNgayRutTien(),
                        rt.getTrangThai(),
                        rt.getTknh() != null ? rt.getTknh().getTknhID() : null,
                        rt.getTknh() != null ? rt.getTknh().getStk() : null,
                        rt.getTknh() != null ? rt.getTknh().getTenNH() : null
                )).toList()
        );
    }

    @Transactional
    public ResponseEntity<?> requestRefundTransaction(RefundTransactionRequest request) {
        String userID = Objects.requireNonNull(
                SecurityContextHolder.getContext().getAuthentication()
        ).getName();
        GiaoDich giaoDich = giaoDichRepository.findById(request.getGiaoDichID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (giaoDich.getTrangThai() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (!giaoDich.getHocVien().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (giaoDichHoanTienRepository.existsByGiaoDich_GiaoDichID(giaoDich.getGiaoDichID())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        GiaoDichHoanTien giaoDichHoanTien = new GiaoDichHoanTien();
        giaoDichHoanTien.setGiaoDich(giaoDich);
        giaoDichHoanTien.setTrangThai(0);
        giaoDichHoanTien.setLiDo(request.getLiDo());
        giaoDichHoanTien.setNgayTao(LocalDateTime.now());
        giaoDichHoanTienRepository.save(giaoDichHoanTien);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public void acceptRefund(String hoanTienID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("proc_accept_refund");

        query.registerStoredProcedureParameter("p_hoantien_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_user_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_status_code", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_message", String.class, ParameterMode.OUT);

        query.setParameter("p_hoantien_id", hoanTienID);
        query.setParameter("p_user_id", userID);

        query.execute();

        Integer statusCode = (Integer) query.getOutputParameterValue("p_status_code");
        String message = (String) query.getOutputParameterValue("p_message");

        if (statusCode != 200) {
            System.out.println(message);
            if (statusCode == -20001 || statusCode == -20002 || statusCode == -20004) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
            } else if (statusCode == -20003) {
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, message);
            } else {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database Error: " + message);
            }
        }
    }

    @Transactional
    public void rejectRefund(String hoanTienID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        GiaoDichHoanTien giaoDichHoanTien = giaoDichHoanTienRepository.findById(hoanTienID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (giaoDichHoanTien.getTrangThai() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        giaoDichHoanTien.setTrangThai(2);
        giaoDichHoanTien.setNhanVienXuLy(nhanVien);

        notificationService.createNotification(
                "Đã từ chối hoàn tiền giao dịch " + giaoDichHoanTien.getGiaoDich().getGiaoDichID(),
                "Chúng tôi đã từ chối hoàn tiền vì đã xem xét kỹ lưỡng, xin cảm ơn!",
                giaoDichHoanTien.getGiaoDich().getHocVien().getUser()
        );
    }

    @Transactional
    public ResponseEntity<?> createTransaction(CreateTransactionRequest request) {
        String userID = Objects.requireNonNull(
                SecurityContextHolder.getContext().getAuthentication()
        ).getName();

        Map<String, Object> result = giaoDichRepository.callCreateTransactionProcedure(
                userID,
                request.getKhoaHocID(),
                request.getVoucherID(),
                request.getCongGD()
        );

        Integer statusCode = (Integer) result.get("p_status_code");
        String message = (String) result.get("p_message");

            System.out.println(message);
        if (statusCode == 200) {
            return ResponseEntity.ok().body(Map.of("message", message));
        } else if (statusCode == -20003 || statusCode == -20005) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, message);
        } else if (statusCode == -20001 || statusCode == -20002 || statusCode == -20004) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, message);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Database Error: " + message);
        }
    }

    @Transactional
    public void createWithdraw(CreateWithdrawRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("proc_TaoPhieuRutTien");

        query.registerStoredProcedureParameter("p_user_id", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_sotienrut", java.math.BigDecimal.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_tknh_id", String.class, ParameterMode.IN);

        query.setParameter("p_user_id", userID);
        query.setParameter("p_sotienrut", request.getSoTienRut());
        query.setParameter("p_tknh_id", request.getTknhID());

        query.execute();

        ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Tạo phiếu rút tiền thành công!"
        ));
    }

    @Transactional
    public List<WithdrawResponse> getMyWithdraws() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<PhieuRutTien> danhSach = phieuRutTienRepository.findByNguoiHuongDan_UserID(userID);
        return danhSach.stream().map(
                rt -> new WithdrawResponse(
                        rt.getRutTienID(),
                        rt.getSoTienRut(),
                        rt.getNgayRutTien(),
                        rt.getTrangThai(),
                        rt.getTknh().getTknhID(),
                        rt.getTknh().getStk(),
                        rt.getTknh().getTenNH()
                )
        ).toList();
    }

}
