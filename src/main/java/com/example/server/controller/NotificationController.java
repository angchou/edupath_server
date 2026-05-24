package com.example.server.controller;

import com.example.server.dto.response.NotificationResponse;
import com.example.server.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
@CrossOrigin(origins = "http://localhost:6969")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/all")
    @PreAuthorize("isAuthenticated()")
    public List<NotificationResponse> getNotifications() {
        return notificationService.getNotifications();
    }

    @DeleteMapping("/delete/{thongBaoID}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> deleteNotification(@PathVariable String thongBaoID) {
        return notificationService.deleteNotification(thongBaoID);
    }

    @DeleteMapping("/delete/all")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> deleteAllNotifications() {
        return notificationService.deleteAllNotifications();
    }
}
