package com.example.server.controller;

import com.example.server.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "http://localhost:6969")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file, @RequestParam("khoaHocID") String khoaHocID) {
        System.out.println(file.getOriginalFilename()); // filename
        System.out.println(file.getSize()); // size

        System.out.println(khoaHocID);

        imageService.uploadImage(file, khoaHocID);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/block/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<?> uploadImageResource(@RequestParam("image") MultipartFile file, @RequestParam("baiHocID") String baiHocID) {
        System.out.println(file.getOriginalFilename()); // filename
        System.out.println(file.getSize()); // size

        System.out.println(baiHocID);

        imageService.uploadImageResource(file, baiHocID);

        return ResponseEntity.ok().build();
    }

}
