package com.example.server.service;

import com.example.server.dto.response.NotificationResponse;
import com.example.server.entities.ThongBao;
import com.example.server.entities.Users;
import com.example.server.repositories.ThongBaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class NotificationService {

    @Autowired
    private ThongBaoRepository thongBaoRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Transactional
    public void createNotification(String tieuDe, String noiDung, Users user) {
        ThongBao thongBao = new ThongBao();
        thongBao.setTieuDe(tieuDe);
        thongBao.setNoiDung(noiDung);
        thongBao.setUser(user);

        thongBaoRepository.save(thongBao);

        NotificationResponse dto = new NotificationResponse(thongBao);

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                messagingTemplate.convertAndSendToUser(
                        user.getUserID(),
                        "/queue/notifications",
                        dto
                );
            }
        });
    }

    public List<NotificationResponse> getNotifications() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        List<ThongBao> danhSachThongBao =  thongBaoRepository.findByUser_UserID(userID);

        return danhSachThongBao.stream().map(
                NotificationResponse::new
        ).toList();
    }

    @Transactional
    public ResponseEntity<?> deleteNotification(String thongBaoID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        ThongBao thongBao = thongBaoRepository.findById(thongBaoID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!thongBao.getUser().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        thongBaoRepository.delete(thongBao);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteAllNotifications() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        thongBaoRepository.deleteAllByUserID(userID);
        return ResponseEntity.ok().build();
    }
}
