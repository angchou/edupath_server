package com.example.server.service;

import com.example.server.entities.BaiHoc;
import com.example.server.entities.KhoaHoc;
import com.example.server.entities.TaiNguyen;
import com.example.server.repositories.BaiHocRepository;
import com.example.server.repositories.TaiNguyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class VideoService {

    private static final String UPLOAD_DIR = "uploads/";

    @Autowired
    private BaiHocRepository baiHocRepository;
    @Autowired
    private TaiNguyenRepository taiNguyenRepository;

    @Transactional
    public void uploadVideo(MultipartFile file, String baiHocID) {
        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + filename);

            Files.createDirectories(path.getParent());
            Files.copy(file.getInputStream(), path);

            String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

            BaiHoc baiHoc = baiHocRepository.findById(baiHocID)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bài học không tồn tại!"));

            if (!baiHoc.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Người dùng không sở hữu khóa học này!");
            }

            TaiNguyen taiNguyen = new TaiNguyen();
            taiNguyen.setStt(taiNguyenRepository.findMaxSttByBaiHoc(baiHocID) + 1);
            taiNguyen.setBaiHoc(baiHoc);
            taiNguyen.setLoaiTN(2);
            taiNguyen.setText(null);
            taiNguyen.setUrl("/" + UPLOAD_DIR + filename);

            taiNguyenRepository.save(taiNguyen);
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("Lỗi xử lý file video: " + e.getMessage());
        }
    }

}
