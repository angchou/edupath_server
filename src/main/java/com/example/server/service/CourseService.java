package com.example.server.service;

import com.example.server.actions.CourseActions;
import com.example.server.dto.request.*;
import com.example.server.dto.response.*;
import com.example.server.entities.*;
import com.example.server.repositories.*;
import com.example.server.utils.CourseStatusControl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    @Autowired
    private BaiHocRepository baiHocRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhieuDanhGiaRepository phieuDanhGiaRepository;
    @Autowired
    private PhieuDanhDauKHRepository phieuDanhDauKHRepository;
    @Autowired
    private HocVienRepository hocVienRepository;
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    @Autowired
    private NotificationService notificationService;

    // -------- //

    // GET

    public CourseCardResponse getCourse(String khoaHocID) {
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new CourseCardResponse(
                khoaHoc.getKhoaHocID(),
                khoaHoc.getTenKH(),
                khoaHoc.getMoTa(),
                khoaHoc.getSlhv(),
                khoaHoc.getNgayTao(),
                khoaHoc.getMucPhi(),
                khoaHoc.getUrl(),
                khoaHoc.getTinhTrang(),
                khoaHoc.getLoaiKH(),
                khoaHoc.getThoiHan(),
                khoaHoc.getNguoiHuongDan().getUserID(),
                khoaHoc.getNguoiHuongDan().getUser().getHoTen()
        );
    }

    public List<CourseCardResponse> getPublicCourses() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByTinhTrang(6);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        thamGiaKHRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanAfter(khoaHoc.getKhoaHocID(), userID, LocalDate.now()),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen(),
                        khoaHocRepository.getCurrentStudentsCount(khoaHoc.getKhoaHocID())
                )
        ).toList();
    }

    public List<CourseCardResponse> getRequestOpenCourses() {
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByTinhTrang(3);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getWaitingPublicCourses() {
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByTinhTrang(4);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getLockedAndPublicCourses() {
        List<Integer> list = List.of(5, 6);
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findByTinhTrangIn(list);

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getBannedCourses() {
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
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getAllCourses() {
        List<KhoaHoc> danhSachKhoaHoc = khoaHocRepository.findAll();

        return danhSachKhoaHoc.stream().map(
                khoaHoc -> new CourseCardResponse(
                        khoaHoc.getKhoaHocID(),
                        khoaHoc.getTenKH(),
                        khoaHoc.getMoTa(),
                        khoaHoc.getSlhv(),
                        khoaHoc.getNgayTao(),
                        khoaHoc.getMucPhi(),
                        khoaHoc.getUrl(),
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen()
                )
        ).toList();
    }

    public List<CourseCardResponse> getMyActiveCourses() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<ThamGiaKH> danhSachThamGia = thamGiaKHRepository.findActiveCourses(userID, LocalDate.now());

        return danhSachThamGia.stream().map(
                thamGia -> new CourseCardResponse(
                        thamGia.getKhoaHoc().getKhoaHocID(),
                        thamGia.getKhoaHoc().getTenKH(),
                        thamGia.getKhoaHoc().getMoTa(),
                        thamGia.getKhoaHoc().getSlhv(),
                        thamGia.getKhoaHoc().getNgayTao(),
                        thamGia.getKhoaHoc().getMucPhi(),
                        thamGia.getKhoaHoc().getUrl(),
                        thamGia.getKhoaHoc().getTinhTrang(),
                        thamGia.getKhoaHoc().getLoaiKH(),
                        (int) ChronoUnit.DAYS.between(LocalDate.now(), thamGia.getNgayHetHan()),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUserID(),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUser().getHoTen()
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
                        thamGia.getKhoaHoc().getTinhTrang(),
                        thamGia.getKhoaHoc().getLoaiKH(),
                        (int) ChronoUnit.DAYS.between(LocalDate.now(), thamGia.getNgayHetHan()),
                        phieuDanhGiaRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserID(thamGia.getKhoaHoc().getKhoaHocID(), userID),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUserID(),
                        thamGia.getKhoaHoc().getNguoiHuongDan().getUser().getHoTen(),
                        thamGia.getNgayDangKy().plusDays(3).isBefore(LocalDate.now())
                )
        ).toList();
    }

    public List<CourseCardResponse> getCreatedCourses() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
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
                        khoaHoc.getTinhTrang(),
                        khoaHoc.getLoaiKH(),
                        khoaHoc.getThoiHan(),
                        true,
                        khoaHoc.getNguoiHuongDan().getUserID(),
                        khoaHoc.getNguoiHuongDan().getUser().getHoTen(),
                        khoaHocRepository.getCurrentStudentsCount(khoaHoc.getKhoaHocID())
                )
        ).toList();
    }

    public List<LessonResponse> getLessons(String khoaHocID) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        List<BaiHoc> danhSachBaiHoc = baiHocRepository.findByKhoaHoc_KhoaHocIDOrderBySttAsc(khoaHocID);
        // kiem tra so huu
        if (CourseStatusControl.isDisabled(
                CourseActions.GET_LESSON,
                khoaHocRepository.findTinhTrangByKhoaHocID(khoaHocID)
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        boolean isNhanVien = nhanVienRepository.existsById(userID);

        boolean isNguoiHuongDan = khoaHocRepository.existsByKhoaHocIDAndNguoiHuongDan_UserID(khoaHocID, userID);

        boolean isHocVienConHan = thamGiaKHRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanAfter(khoaHocID, userID, LocalDate.now());
        if (!isNhanVien && !isNguoiHuongDan && !isHocVienConHan) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        return danhSachBaiHoc.stream().map(
                baiHoc -> new LessonResponse(
                        baiHoc.getBaiHocID(),
                        baiHoc.getTenBaiHoc(),
                        baiHoc.getStt()
                )
        ).toList();
    }

    public List<LessonResponse> getDemoLessons(String khoaHocID) {
        List<BaiHoc> danhSachBaiHoc = baiHocRepository.findTop2ByKhoaHoc_KhoaHocIDOrderBySttAsc(khoaHocID);

        if (CourseStatusControl.isDisabled(
                CourseActions.GET_DEMO,
                khoaHocRepository.findTinhTrangByKhoaHocID(khoaHocID)
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        return danhSachBaiHoc.stream().map(
                baiHoc -> new LessonResponse(
                        baiHoc.getBaiHocID(),
                        baiHoc.getTenBaiHoc(),
                        baiHoc.getStt()
                )
        ).toList();
    }
    public List<CourseResourceResponse> getDemoResource(String baiHocID) {
        BaiHoc currentLesson = baiHocRepository.findById(baiHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        List<BaiHoc> demoLessons = baiHocRepository.findTop2ByKhoaHoc_KhoaHocIDOrderBySttAsc(currentLesson.getKhoaHoc().getKhoaHocID());

        boolean isDemo = demoLessons.stream()
                .anyMatch(bh -> bh.getBaiHocID().equals(baiHocID));
        if (CourseStatusControl.isDisabled(
                CourseActions.GET_DEMO,
                khoaHocRepository.findTinhTrangByKhoaHocID(demoLessons.getFirst().getKhoaHoc().getKhoaHocID())
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (!isDemo) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        List<TaiNguyen> danhSachTaiNguyen = taiNguyenRepository.findByBaiHoc_BaiHocIDOrderBySttAsc(baiHocID);
        return danhSachTaiNguyen.stream().map(taiNguyen -> new CourseResourceResponse(
                taiNguyen.getTaiNguyenID(),
                taiNguyen.getUrl(),
                taiNguyen.getLoaiTN(),
                taiNguyen.getStt(),
                taiNguyen.getText()
        )).toList();
    }

    public List<CourseResourceResponse> getLessonResource(String baiHocID) {
        // kiem tra so huu
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        BaiHoc baiHoc = baiHocRepository.findById(baiHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        boolean isHocVienConHan = thamGiaKHRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanAfter(baiHoc.getKhoaHoc().getKhoaHocID(), userID, LocalDate.now());
        if (!baiHoc.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)
                && !nhanVienRepository.existsById(userID)
                && !isHocVienConHan
        ) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        if (CourseStatusControl.isDisabled(
                CourseActions.GET_RESOURCE,
                baiHoc.getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        List<TaiNguyen> danhSachTaiNguyen = taiNguyenRepository.findByBaiHoc_BaiHocIDOrderBySttAsc(baiHocID);

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

    public List<RatingResponse> getCourseRatings(String khoaHocID) {
        List<PhieuDanhGia> danhSachDanhGia = phieuDanhGiaRepository.findByKhoaHoc_KhoaHocID(khoaHocID);
        return danhSachDanhGia.stream().map(
                phieu -> new RatingResponse(
                        phieu.getPhieuDanhGiaID(),
                        phieu.getChiTiet(),
                        phieu.getDiemDanhGia(),
                        phieu.getNgayTao(),
                        phieu.getHocVien().getUserID(),
                        phieu.getHocVien().getUser().getHoTen(),
                        phieu.getHocVien().getUser().getEmail()
                )
        ).toList();
    }

    public RatingResponse getRating(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        PhieuDanhGia phieuDanhGia = phieuDanhGiaRepository.findByKhoaHoc_KhoaHocIDAndHocVien_UserID(khoaHocID, userID);
        return new RatingResponse(
                phieuDanhGia.getPhieuDanhGiaID(),
                phieuDanhGia.getChiTiet(),
                phieuDanhGia.getDiemDanhGia(),
                phieuDanhGia.getNgayTao()
        );
    }

    public List<CourseMarkResponse> getCourseMarks(String khoaHocID) {
        List<PhieuDanhDauKH> danhSach = phieuDanhDauKHRepository.findByKhoaHoc_KhoaHocID(khoaHocID);

        return danhSach.stream().map(
                phieu -> new CourseMarkResponse(
                        phieu.getPhieuDanhDauID(),
                        phieu.getMoTa(),
                        phieu.getMucDanhDau(),
                        phieu.getNhanVien().getUserID()
                )
        ).toList();
    }

    // POST
    @Transactional
    public ResponseEntity<?> createMarkCourse(CreateMarkCourseRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        NhanVien nhanVien = nhanVienRepository.findByUser_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.MARK_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        PhieuDanhDauKH phieuDanhDauKH = new PhieuDanhDauKH();
        phieuDanhDauKH.setKhoaHoc(khoaHoc);
        phieuDanhDauKH.setNhanVien(nhanVien);
        phieuDanhDauKH.setMoTa(request.getMoTa());
        phieuDanhDauKH.setMucDanhDau(request.getMucDanhDau());
        phieuDanhDauKHRepository.save(phieuDanhDauKH);

        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã bị đánh dấu", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã bị đánh dấu, vui lòng xem phiếu đánh dấu và xử lý vấn đề nhanh chóng!", khoaHoc.getNguoiHuongDan().getUser());

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> createLesson(CreateLessonRequest request) {
        // find userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find khoa hoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // check so huu khoa hoc
        if (!khoaHoc.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.CREATE_LESSON,
                khoaHoc.getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        // create bai hoc
        BaiHoc baiHoc = new BaiHoc();
        baiHoc.setKhoaHoc(khoaHoc);
        baiHoc.setTenBaiHoc(request.getTenBaiHoc());
        baiHoc.setStt(baiHocRepository.findMaxSttByKhoaHoc(request.getKhoaHocID()) + 1);
        baiHocRepository.save(baiHoc);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public String createNewCourse(CreateCourseRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();

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
        khoaHoc.setTinhTrang(2);
        khoaHoc.setNguoiHuongDan(user);
        khoaHoc.setNgayTao(LocalDate.now());
        khoaHoc.setThoiHan(request.getThoiHan());

        // save khoa hoc
        KhoaHoc savedCourse = khoaHocRepository.save(khoaHoc);

        return savedCourse.getKhoaHocID();
    }

    @Transactional
    public ResponseEntity<?> createTextBlock(CreateBlockRequest request) {
        // find userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        BaiHoc baiHoc = baiHocRepository.findById(request.getBaiHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // check so huu
        if (!baiHoc.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        if (CourseStatusControl.isDisabled(
                CourseActions.CREATE_RESOURCE,
                baiHoc.getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        // create resource
        TaiNguyen taiNguyen = new TaiNguyen();
        taiNguyen.setBaiHoc(baiHoc);
        taiNguyen.setUrl(request.getUrl());
        taiNguyen.setLoaiTN(0);
        taiNguyen.setText(request.getText());
        taiNguyen.setStt(taiNguyenRepository.findMaxSttByBaiHoc(request.getBaiHocID()) + 1);
        taiNguyenRepository.save(taiNguyen);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> createRating(CreateRatingRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        if (!thamGiaKHRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanAfter(request.getKhoaHocID(), userID, LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (phieuDanhGiaRepository.existsByKhoaHoc_KhoaHocIDAndHocVien_UserID(request.getKhoaHocID(), userID)) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        HocVien hocVien = hocVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        ThamGiaKH thamGiaKH = thamGiaKHRepository.findByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanGreaterThanEqual(
                khoaHoc.getKhoaHocID(),
                hocVien.getUserID(),
                LocalDate.now()
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (thamGiaKH.getNgayDangKy().plusDays(3).isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        PhieuDanhGia phieuDanhGia = new PhieuDanhGia();
        phieuDanhGia.setChiTiet(request.getChiTiet());
        phieuDanhGia.setDiemDanhGia(request.getDiemDanhGia());
        phieuDanhGia.setNgayTao(LocalDate.now());
        phieuDanhGia.setKhoaHoc(khoaHoc);
        phieuDanhGia.setHocVien(hocVien);
        phieuDanhGiaRepository.save(phieuDanhGia);

        return ResponseEntity.ok().build();
    }

    // DELETE
    @Transactional
    public ResponseEntity<?> deleteMarkCourse(String phieuDanhDauID) {
        PhieuDanhDauKH phieuDanhDauKH = phieuDanhDauKHRepository.findById(phieuDanhDauID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.UNMARK_COURSE, phieuDanhDauKH.getKhoaHoc().getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        phieuDanhDauKHRepository.delete(phieuDanhDauKH);

        notificationService.createNotification("Khóa học " + phieuDanhDauKH.getKhoaHoc().getKhoaHocID()
                + " đã được xóa phiếu đánh dấu", "Khóa học " + phieuDanhDauKH.getKhoaHoc().getKhoaHocID()
                + " - " + phieuDanhDauKH.getKhoaHoc().getTenKH()
                + " của bạn đã được chúng tôi xem xét lại và xóa phiếu đánh dấu, vui lòng kiểm tra lại và liên hệ hỗ trợ nếu xảy ra lỗi!", phieuDanhDauKH.getKhoaHoc().getNguoiHuongDan().getUser());

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteLesson(String baiHocID) {
        // userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        BaiHoc baiHoc = baiHocRepository.findById(baiHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // check so huu
        if (!baiHoc.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        if (CourseStatusControl.isDisabled(
                CourseActions.DELETE_LESSON,
                baiHoc.getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        // delete bai hoc
        baiHocRepository.delete(baiHoc);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteResource(String taiNguyenID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        TaiNguyen taiNguyen = taiNguyenRepository.findById(taiNguyenID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiNguyen.getBaiHoc().getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.DELETE_RESOURCE,
                taiNguyen.getBaiHoc().getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        if (taiNguyen.getLoaiTN() != 0) {
            String filePath = taiNguyen.getUrl(); // ví dụ: /uploads/abc.jpg
            if (filePath != null && filePath.startsWith("/uploads/")) {
                try {
                    String rootPath = System.getProperty("user.dir");
                    String cleanPath = filePath.substring(1);
                    Path path = Paths.get(rootPath, cleanPath);
                    Files.deleteIfExists(path);
                    System.out.println("Đã xóa file: " + path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        taiNguyenRepository.delete(taiNguyen);
        return ResponseEntity.ok().build();
    }

    // PATCH
    @Transactional
    public ResponseEntity<?> lockCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find khoa hoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.LOCK_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(5);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> requestOpenCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find khoa hoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(
                CourseActions.REQUEST_OPEN,
                khoaHoc.getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(3);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> approveCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (khoaHoc.getTinhTrang() != 3) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setNhanVienKiemDuyet(nhanVien);
        khoaHoc.setTinhTrang(4);

        Users user = userRepository.findById(khoaHoc.getNguoiHuongDan().getUserID())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã được kiểm duyệt thành công", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã được bộ phận Đảm bảo chất lượng kiểm duyệt thành công, phía quản trị viên sẽ sớm mở công khai khóa học cho bạn!", user);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> rejectCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.REJECT_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setNhanVienKiemDuyet(nhanVien);
        khoaHoc.setTinhTrang(2);

        Users user = userRepository.findById(khoaHoc.getNguoiHuongDan().getUserID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã bị từ chối", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã bị từ chối, vui lòng điều chỉnh lại khóa học của bạn hoặc liên hệ phía hỗ " +
                "trợ của chúng tôi!", user);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> banCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.BAN_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(1);

        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã bị chặn", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã bị chặn vì đã vi phạm tiêu chuẩn của chúng tôi!",
                khoaHoc.getNguoiHuongDan().getUser());

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> unbanCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.UNBAN_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(2);

        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã được gỡ chặn", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã được gỡ lệnh chặn, khóa học sẽ được chỉnh về trạng thái không công khai!", khoaHoc.getNguoiHuongDan().getUser());

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> publicCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.PUBLIC_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(6);

        Users user = userRepository.findById(khoaHoc.getNguoiHuongDan().getUserID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã được mở công khai", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã được mở công khai cho các học viên khác, nếu có vấn đề gì xảy ra, vui lòng liên hệ phía hỗ trợ của chúng tôi để được giải đáp!", user);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> deleteCourse(String khoaHocID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (CourseStatusControl.isDisabled(CourseActions.DELETE_COURSE, khoaHoc.getTinhTrang())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        khoaHoc.setTinhTrang(0);

        Users user = userRepository.findById(khoaHoc.getNguoiHuongDan().getUserID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        notificationService.createNotification("Khóa học " + khoaHoc.getKhoaHocID()
                + " đã bị xóa", "Khóa học " + khoaHoc.getKhoaHocID()
                + " - " + khoaHoc.getTenKH()
                + " của bạn đã bị xóa vì vi phạm nghiêm trọng chính sách của chúng tôi, khóa học sẽ bị vô hiệu hóa vĩnh viễn!", user);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> updateCourse(UpdateCourseRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find khoa hoc
        KhoaHoc khoaHoc = khoaHocRepository.findById(request.getKhoaHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!khoaHoc.getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.UPDATE_COURSE,
                khoaHoc.getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        // check tenKH
        if (!khoaHoc.getTenKH().equals(request.getTenKH())) {
            khoaHoc.setTenKH(request.getTenKH());
        }
        // check moTa
        if (!khoaHoc.getMoTa().equals(request.getMoTa())) {
            khoaHoc.setMoTa(request.getMoTa());
        }
        // check muc phi
        if (!khoaHoc.getMucPhi().equals(request.getMucPhi())) {
            khoaHoc.setMucPhi(request.getMucPhi());
        }
        // check loaiKH
        if (khoaHoc.getLoaiKH() != request.getLoaiKH()) {
            khoaHoc.setLoaiKH(request.getLoaiKH());
        }

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> updateLesson(UpdateLessonRequest request) {
        // get userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        BaiHoc baiHoc = baiHocRepository.findById(request.getBaiHocID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // check so huu
        if (!baiHoc.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.UPDATE_LESSON,
                baiHoc.getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        // update
        baiHoc.setTenBaiHoc(request.getTenBaiHoc());
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> swapLessonPriority(SwapLessonPriorityRequest request) {
        // find userID
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find bai hoc
        BaiHoc baiHoc1 = baiHocRepository.findById(request.getBaiHoc1())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        BaiHoc baiHoc2 = baiHocRepository.findById(request.getBaiHoc2())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!baiHoc1.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)
            || !baiHoc2.getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)
            || !baiHoc1.getKhoaHoc().getKhoaHocID().equals(baiHoc2.getKhoaHoc().getKhoaHocID())
        ) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.UPDATE_LESSON,
                baiHoc1.getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        int temp = baiHoc1.getStt();
        baiHoc1.setStt(baiHoc2.getStt());
        baiHoc2.setStt(temp);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> updateResourceBlock(UpdateBlockRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        TaiNguyen taiNguyen = taiNguyenRepository.findById(request.getTaiNguyenID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiNguyen.getBaiHoc().getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.UPDATE_RESOURCE,
                taiNguyen.getBaiHoc().getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        taiNguyen.setUrl(request.getUrl());
        taiNguyen.setLoaiTN(request.getLoaiTN());
        taiNguyen.setText(request.getText());

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> swapResourcePriority(SwapResourcePriorityRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // tai nguyen
        TaiNguyen taiNguyen1 = taiNguyenRepository.findById(request.getTaiNguyen1())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        TaiNguyen taiNguyen2 = taiNguyenRepository.findById(request.getTaiNguyen2())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!taiNguyen1.getBaiHoc().getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)
            || !taiNguyen2.getBaiHoc().getKhoaHoc().getNguoiHuongDan().getUserID().equals(userID)
            || !taiNguyen1.getBaiHoc().getKhoaHoc().getKhoaHocID().equals(taiNguyen2.getBaiHoc().getKhoaHoc().getKhoaHocID())
        ) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (CourseStatusControl.isDisabled(
                CourseActions.UPDATE_RESOURCE,
                taiNguyen1.getBaiHoc().getKhoaHoc().getTinhTrang()
        )) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

        int temp = taiNguyen1.getStt();
        taiNguyen1.setStt(taiNguyen2.getStt());
        taiNguyen2.setStt(temp);

        return ResponseEntity.ok().build();
    }
}