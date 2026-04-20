package com.example.server.service;

import com.example.server.dto.request.CourseTextUploadRequest;
import com.example.server.dto.request.CreateCourseRequest;
import com.example.server.dto.response.CourseCardResponse;
import com.example.server.dto.response.CourseResourceResponse;
import com.example.server.entities.*;
import com.example.server.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class CourseService {

    @Autowired
    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private ThamGiaKHRepository thamGiaKHRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;
    @Autowired
    private TaiNguyenRepository taiNguyenRepository;

    // -------- //

    public List<CourseCardResponse> getNormalCourses() {
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByTinhTrang(1);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getMyCourses() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<ThamGiaKH> danhSachThamGia = thamGiaKHRepository.findByHocVien_UserID(userID);

        return danhSachThamGia.stream().map(
                thamGia -> new CourseCardResponse(
                        thamGia.getKhoaHoc().getKhoaHocID(),
                        thamGia.getKhoaHoc().getTenKH(),
                        thamGia.getKhoaHoc().getMoTa(),
                        thamGia.getKhoaHoc().getSlhv(),
                        thamGia.getKhoaHoc().getNgayTao(),
                        thamGia.getKhoaHoc().getMucPhi(),
                        thamGia.getKhoaHoc().getUrl(),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUserID(),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getCreatedCourses() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication().getName());
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByNguoiHuongDan_UserID(userID);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseResourceResponse> getCourseResource(String khoaHocID) {
        List<TaiNguyen> danhSachTaiNguyen = taiNguyenRepository.findByKhoaHoc_KhoaHocID(khoaHocID);

        return danhSachTaiNguyen.stream().map(
                taiNguyen -> new CourseResourceResponse(
                        taiNguyen.getTaiNguyenID(),
                        taiNguyen.getUrl(),
                        taiNguyen.getLoaiTN(),
                        taiNguyen.getStt(),
                        taiNguyen.getText()
                )
        ).toList();
    }

    @Transactional
    public String createNewCourse(CreateCourseRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication().getName());

        // find nguoiHuongDan
        NguoiHuongDan user = nguoiHuongDanRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Người dùng không tồn tại!"));

        // create course
        KhoaHoc khoaHoc = new KhoaHoc();
        khoaHoc.setTenKH(request.getTenKH());
        khoaHoc.setLoaiKH(request.getLoaiKH());
        khoaHoc.setMoTa(request.getMoTa());
        khoaHoc.setMucPhi(request.getMucPhi());
        khoaHoc.setSlhv(request.getSlhv());
        khoaHoc.setTinhTrang(1);
        khoaHoc.setNguoiHuongDan(user);

        khoaHoc.setNgayTao(LocalDate.now());

        // save khoa hoc
        KhoaHoc savedCourse = khoaHocRepository.save(khoaHoc);

        return savedCourse.getKhoaHocID();
    }

    @Transactional
    public ResponseEntity<?> createText(String khoaHocID, CourseTextUploadRequest request) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        // get khoaHoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

        // khoahoc.userId = userID ?
        if (!khoaHoc.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new RuntimeException("Không phải người sở hữu khóa học");
        }

        // create tainguyen
        TaiNguyen taiNguyen = new TaiNguyen();
        taiNguyen.setKhoaHoc(khoaHoc);
        taiNguyen.setUrl(request.getUrl());
        taiNguyen.setLoaiTN(request.getLoaiTN());
        taiNguyen.setStt(request.getStt());
        taiNguyen.setText(request.getText());

        taiNguyenRepository.save(taiNguyen);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteResource(String khoaHocID, String taiNguyenID) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

        // get khoaHoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

        // khoahoc.userId = userID ?
        if (!khoaHoc.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new RuntimeException("Không phải người sở hữu khóa học");
        }

        // delete tai nguyen
        taiNguyenRepository.deleteById(taiNguyenID);

        return ResponseEntity.ok().build();
    }
}