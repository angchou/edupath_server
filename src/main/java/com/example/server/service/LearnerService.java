package com.example.server.service;

import com.example.server.entities.HSDangKyMentor;
import com.example.server.entities.HocVien;
import com.example.server.repositories.HSDangKyMentorRepository;
import com.example.server.repositories.HocVienRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class LearnerService {

    @Autowired
    private HSDangKyMentorRepository hsDangKyMentorRepository;
    @Autowired
    private HocVienRepository hocVienRepository;

    public ResponseEntity<?> getMyApplication() {
        String userID = Objects.requireNonNull(
                SecurityContextHolder.getContext().getAuthentication()
        ).getName();

        Optional<HSDangKyMentor> optional = hsDangKyMentorRepository
                .findByHocVien_UserID(userID);

        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }

        return ResponseEntity.ok(null);
    }

    public ResponseEntity<?> viewPDF(String fileName) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        try {
            Path filePath = Paths.get(System.getProperty("user.dir")).resolve("upload").resolve(fileName);
            UrlResource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_PDF)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @Transactional
    public ResponseEntity<?> deleteApplication() {
        String userID = Objects.requireNonNull(
                SecurityContextHolder.getContext().getAuthentication()
        ).getName();

        HSDangKyMentor hsDangKyMentor = hsDangKyMentorRepository
                .findByHocVien_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        try {
            String fileName = hsDangKyMentor.getUrl();

            Path filePath = Paths.get(System.getProperty("user.dir"))
                    .resolve("upload")
                    .resolve(fileName);

            if (Files.exists(filePath)) {
                Files.delete(filePath);
            }

            hsDangKyMentorRepository.delete(hsDangKyMentor);

            return ResponseEntity.ok("Xóa hồ sơ thành công");

        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Không thể xóa file"
            );
        }
    }

    @Transactional
    public ResponseEntity<?> uploadMentorApplication(MultipartFile file, String tenHoSo) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        if (hsDangKyMentorRepository.existsByHocVien_UserID(userID)) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();

            System.out.println("Nhận file: " + fileName);
            System.out.println("Tên lưu trữ: " + tenHoSo);

            String projectRoot = System.getProperty("user.dir");
            Path uploadPath = Paths.get(projectRoot, "upload");

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFileName = file.getOriginalFilename();
            assert originalFileName != null;
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String finalFileName = tenHoSo.replaceAll("[^a-zA-Z0-9\\.\\-]", "_") + extension + System.currentTimeMillis();

            Path filePath = uploadPath.resolve(finalFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            HocVien hocVien = hocVienRepository.findById(userID)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            HSDangKyMentor hsDangKyMentor = new HSDangKyMentor();
            hsDangKyMentor.setHocVien(hocVien);
            hsDangKyMentor.setNgayTao(LocalDate.now());
            hsDangKyMentor.setUrl(finalFileName);
            hsDangKyMentor.setTrangThai(0);
            hsDangKyMentorRepository.save(hsDangKyMentor);

            return ResponseEntity.ok("Đã lưu hồ sơ thành công tại: " + filePath.toString());
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Lỗi khi xử lý file");
        }
    }
}
