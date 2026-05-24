package com.example.server.service;

import com.example.server.dto.request.MessageRequest;
import com.example.server.dto.response.ConversationResponse;
import com.example.server.dto.response.CustomerResponse;
import com.example.server.dto.response.MessageResponse;
import com.example.server.entities.CuocTroChuyen;
import com.example.server.entities.ThamGiaKH;
import com.example.server.entities.TinNhan;
import com.example.server.entities.Users;
import com.example.server.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class MessageService {
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private ThamGiaKHRepository thamGiaKHRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CuocTroChuyenRepository cuocTroChuyenRepository;
    @Autowired
    private TinNhanRepository tinNhanRepository;

    public List<CustomerResponse> getMyMentor() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<ThamGiaKH> danhSachThamGia = thamGiaKHRepository.findActiveCourses(userID, LocalDate.now());
        return danhSachThamGia.stream().map(
                tg -> new CustomerResponse(
                        tg.getKhoaHoc().getNguoiHuongDan().getUserID(),
                        tg.getKhoaHoc().getNguoiHuongDan().getUser().getHoTen(),
                        tg.getKhoaHoc().getNguoiHuongDan().getUser().getEmail(),
                        tg.getKhoaHoc().getNguoiHuongDan().getUser().getNgayTao(),
                        "Người hướng dẫn",
                        tg.getKhoaHoc().getNguoiHuongDan().getUser().getTrangThai()
                )
        ).toList();
    }

    public List<CustomerResponse> getMyStudents() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        List<String> activeHocVienIDs = thamGiaKHRepository.findActiveHocVienIDs(LocalDate.now());
        if (activeHocVienIDs.isEmpty()) {
            return List.of();
        }

        List<CuocTroChuyen> danhSach = cuocTroChuyenRepository.findConversationsWithActiveHocVien(userID, activeHocVienIDs);

        return danhSach.stream().map(c -> {
            var doiTac = c.getNguoiKhoiTao().getUserID().equals(userID) ? c.getNguoiNhan() : c.getNguoiKhoiTao();
            return new CustomerResponse(
                    doiTac.getUserID(),
                    doiTac.getHoTen(),
                    doiTac.getEmail(),
                    doiTac.getNgayTao(),
                    "Học viên",
                    doiTac.getTrangThai()
            );
        }).toList();
    }

    public ConversationResponse getConversation(String targetID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        CuocTroChuyen cuocTroChuyen = cuocTroChuyenRepository.findBetweenUsers(userID, targetID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        boolean isLearnerHasValidCourse = thamGiaKHRepository.existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(targetID, userID, LocalDate.now());
        boolean isTargetHasValidCourse = thamGiaKHRepository.existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(userID, targetID, LocalDate.now());

        boolean isStillValid = isLearnerHasValidCourse || isTargetHasValidCourse;

        return new ConversationResponse(
                cuocTroChuyen.getCuocTroChuyenID(),
                cuocTroChuyen.getThoiGianTao(),
                cuocTroChuyen.getNguoiKhoiTao().getUserID(),
                cuocTroChuyen.getNguoiNhan().getUserID(),
                !isStillValid
        );
    }

    public List<MessageResponse> getMessagesOfConversation(String cuocTroChuyenID) {
        List<TinNhan> danhSach = tinNhanRepository.findByCuocTroChuyen_CuocTroChuyenIDOrderByThoiGianGui(cuocTroChuyenID);
        return danhSach.stream().map(
                tn -> new MessageResponse(
                        tn.getTinNhanID(),
                        tn.getCuocTroChuyen().getCuocTroChuyenID(),
                        tn.getNguoiGui().getUserID(),
                        tn.getThoiGianGui(),
                        tn.getNoiDung()
                )
        ).toList();
    }

    @Transactional
    public MessageResponse responseCreateMessage(MessageRequest request, String userID) {
        Users user1 = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy người dùng gửi"));
        Users user2 = userRepository.findById(request.getNguoiNhan())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy người dùng nhận"));

        CuocTroChuyen cuocTroChuyen = cuocTroChuyenRepository.findBetweenUsers(userID, request.getNguoiNhan())
                .orElse(null);

        if (cuocTroChuyen == null) {
            boolean isConHan = thamGiaKHRepository.existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(
                    request.getNguoiNhan(), userID, LocalDate.now());

            if (!isConHan) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gói tham gia đã hết hạn!");
            }

            cuocTroChuyen = new CuocTroChuyen();
            cuocTroChuyen.setNguoiKhoiTao(user1);
            cuocTroChuyen.setNguoiNhan(user2);
            cuocTroChuyen.setThoiGianTao(LocalDate.now());

            cuocTroChuyen = cuocTroChuyenRepository.save(cuocTroChuyen);
        }

        if (!thamGiaKHRepository.existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(userID, request.getNguoiNhan(), LocalDate.now())
            && !thamGiaKHRepository.existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(request.getNguoiNhan(), userID, LocalDate.now())
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Gói tham gia đã hết hạn!");
        }

        TinNhan tinNhan = new TinNhan();
        tinNhan.setCuocTroChuyen(cuocTroChuyen);
        tinNhan.setNguoiGui(user1);
        tinNhan.setNoiDung(request.getNoiDung());
        tinNhan.setThoiGianGui(LocalDateTime.now());

        tinNhanRepository.save(tinNhan);

        return new MessageResponse(
                tinNhan.getTinNhanID(),
                tinNhan.getCuocTroChuyen().getCuocTroChuyenID(),
                tinNhan.getNguoiGui().getUserID(),
                tinNhan.getThoiGianGui(),
                tinNhan.getNoiDung()
        );
    }}