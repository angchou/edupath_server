package com.example.server.service;

import com.example.server.entities.KhoaHoc;
import com.example.server.repositories.KhoaHocRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class ImageService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private KhoaHocRepository khoaHocRepository;

    @Transactional
    public void uploadImage(MultipartFile file, String khoaHocID) {
        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            Path path = Paths.get(UPLOAD_DIR + filename);

            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path);

            String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication().getName());

            // find khoa hoc
            KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!"));
            if (!khoaHoc.getNguoiHuongDan().getUserID().equals(userID)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Người dùng không sở hữu khóa học này!");
            }

            khoaHoc.setUrl("/" + UPLOAD_DIR + filename);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
