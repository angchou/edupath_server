package com.example.server.service;

import com.example.server.dto.request.CreateCourseRequest;
import com.example.server.dto.response.CourseCardResponse;
import com.example.server.entities.KhoaHoc;
import com.example.server.entities.NguoiHuongDan;
import com.example.server.entities.ThamGiaKH;
import com.example.server.entities.Users;
import com.example.server.repositories.KhoaHocRepository;
import com.example.server.repositories.NguoiHuongDanRepository;
import com.example.server.repositories.ThamGiaKHRepository;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

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

    public ResponseEntity<?> createNewCourse(CreateCourseRequest request) {
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

        // save khoa hoc
        khoaHocRepository.save(khoaHoc);

        return ResponseEntity.ok(khoaHoc.getKhoaHocID());
    }

}