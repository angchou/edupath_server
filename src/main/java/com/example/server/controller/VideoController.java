package com.example.server.controller;

import com.example.server.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/video")
@CrossOrigin(origins = "http://localhost:6969")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> uploadVideo(
            @RequestParam("video") MultipartFile file,
            @RequestParam("baiHocID") String baiHocID) {

        System.out.println("Tên file video: " + file.getOriginalFilename());
        System.out.println("Dung lượng: " + file.getSize() + " bytes");

        // Gọi service xử lý
        videoService.uploadVideo(file, baiHocID);

        return ResponseEntity.ok().build();
    }
}
