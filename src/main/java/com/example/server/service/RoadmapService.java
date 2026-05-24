package com.example.server.service;

import com.example.server.dto.request.EditRoadmapRequest;
import com.example.server.dto.request.RoadmapStepRequest;
import com.example.server.dto.request.UpdateRoadmapDescRequest;
import com.example.server.dto.response.PublicRoadmapResponse;
import com.example.server.dto.response.RoadmapResponse;
import com.example.server.entities.DauViecLoTrinh;
import com.example.server.entities.HocVien;
import com.example.server.entities.LoTrinh;
import com.example.server.entities.NguoiHuongDan;
import com.example.server.repositories.DauViecRepository;
import com.example.server.repositories.HocVienRepository;
import com.example.server.repositories.LoTrinhRepository;
import com.example.server.repositories.NguoiHuongDanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoadmapService {

    @Autowired
    private LoTrinhRepository loTrinhRepository;
    @Autowired
    private NguoiHuongDanRepository nguoiHuongDanRepository;
    @Autowired
    private DauViecRepository dauViecRepository;
    @Autowired
    private HocVienRepository hocVienRepository;

    public RoadmapResponse getMyShareRoadmap() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        LoTrinh loTrinh = loTrinhRepository.findByNguoiHuongDan_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // get danh sach dau viec
        List<DauViecLoTrinh> danhSach = dauViecRepository.findByLoTrinh_LoTrinhIDOrderByStt(loTrinh.getLoTrinhID());
        List<RoadmapStepRequest> danhSachDauViec = danhSach.stream().map(
                dauViec -> new RoadmapStepRequest(
                        dauViec.getDauViecID(),
                        dauViec.getTenDauViec(),
                        dauViec.getStt(),
                        dauViec.getMoTa()
                )
        ).toList();

        RoadmapResponse response = new RoadmapResponse();
        response.setLoTrinhID(loTrinh.getLoTrinhID());
        response.setTrangThai(loTrinh.getTrangThai());
        response.setMoTa(loTrinh.getMoTa());
        response.setDanhSachDauViec(danhSachDauViec);
        return response;
    }

    public RoadmapResponse getMyRoadmap() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        LoTrinh loTrinh = loTrinhRepository.findByHocVien_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // get danh sach dau viec
        List<DauViecLoTrinh> danhSach = dauViecRepository.findByLoTrinh_LoTrinhIDOrderByStt(loTrinh.getLoTrinhID());
        List<RoadmapStepRequest> danhSachDauViec = danhSach.stream().map(
                dauViec -> new RoadmapStepRequest(
                        dauViec.getDauViecID(),
                        dauViec.getTenDauViec(),
                        dauViec.getStt(),
                        dauViec.getMoTa()
                )
        ).toList();

        RoadmapResponse response = new RoadmapResponse();
        response.setLoTrinhID(loTrinh.getLoTrinhID());
        response.setTrangThai(loTrinh.getTrangThai());
        response.setMoTa(loTrinh.getMoTa());
        response.setDanhSachDauViec(danhSachDauViec);
        return response;
    }

    public List<PublicRoadmapResponse> getPublicRoadmap() {
        List<LoTrinh> danhSachLoTrinh = loTrinhRepository.findByTrangThai(1);
        List<PublicRoadmapResponse> response = new ArrayList<>();
        for (LoTrinh loTrinh : danhSachLoTrinh) {
            PublicRoadmapResponse roadmapResponse = new PublicRoadmapResponse();
            roadmapResponse.setLoTrinhID(loTrinh.getLoTrinhID());
            roadmapResponse.setMoTa(loTrinh.getMoTa());
            roadmapResponse.setTrangThai(loTrinh.getTrangThai());
            roadmapResponse.setUserID(loTrinh.getNguoiHuongDan().getUserID());
            roadmapResponse.setHoTen(loTrinh.getNguoiHuongDan().getUser().getHoTen());
            roadmapResponse.setEmail(loTrinh.getNguoiHuongDan().getUser().getEmail());
            List<DauViecLoTrinh> danhSachDauViec = dauViecRepository.findByLoTrinh_LoTrinhIDOrderByStt(loTrinh.getLoTrinhID());
            List<RoadmapStepRequest> danhSachDauViecResponse = danhSachDauViec.stream().map(
                    dauViec -> new RoadmapStepRequest(
                            dauViec.getDauViecID(),
                            dauViec.getTenDauViec(),
                            dauViec.getStt(),
                            dauViec.getMoTa()
                    )
            ).toList();
            roadmapResponse.setDanhSachDauViec(danhSachDauViecResponse);

            response.add(roadmapResponse);
        }
        return response;
    }

    @Transactional
    public ResponseEntity<?> saveRoadmap(EditRoadmapRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        // find roadmap
        LoTrinh loTrinh;
        if (request.getLoTrinhID() != null) {
            loTrinh = loTrinhRepository.findById(request.getLoTrinhID())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }
        else {
            NguoiHuongDan nguoiHuongDan = nguoiHuongDanRepository.findById(userID)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

            loTrinh = new LoTrinh();
            loTrinh.setLaKhuonMau(1);
            loTrinh.setNguoiHuongDan(nguoiHuongDan);
            loTrinh.setTrangThai(0); // private roadmap
            loTrinhRepository.save(loTrinh);
        }
        int temp = 0;

        List<DauViecLoTrinh> currentSteps =
                dauViecRepository.findByLoTrinh_LoTrinhID(loTrinh.getLoTrinhID());
        Set<String> requestIds = request.getDanhSachDauViec().stream()
                .map(RoadmapStepRequest::getDauViecID)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        for (DauViecLoTrinh step : currentSteps) {
            if (!requestIds.contains(step.getDauViecID())) {
                dauViecRepository.delete(step);
            }
        }

        for (RoadmapStepRequest step : request.getDanhSachDauViec()) {
            if (step.getDauViecID() == null) {
                // create new step
                DauViecLoTrinh dauViec = new DauViecLoTrinh();
                dauViec.setTenDauViec(step.getTenDauViec());
                dauViec.setLoTrinh(loTrinh);
                dauViec.setStt(temp);
                dauViec.setMoTa(step.getMoTa());
                dauViecRepository.save(dauViec);
            } else {
                // update old one
                DauViecLoTrinh dauViec = dauViecRepository.findById(step.getDauViecID())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                if (!dauViec.getLoTrinh().getLoTrinhID().equals(loTrinh.getLoTrinhID())) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                // check
                if (!dauViec.getTenDauViec().equals(step.getTenDauViec())) {
                    dauViec.setTenDauViec(step.getTenDauViec());
                }
                if (!dauViec.getMoTa().equals(step.getMoTa())) {
                    dauViec.setMoTa(step.getMoTa());
                }
                dauViec.setStt(temp);
            }
            temp += 10;
        }

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> copyRoadmap(String loTrinhID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        HocVien hocVien = hocVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        // find roadmap
        LoTrinh loTrinhMau = loTrinhRepository.findById(loTrinhID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<DauViecLoTrinh> danhSachDauViecMau = dauViecRepository.findByLoTrinh_LoTrinhID(loTrinhMau.getLoTrinhID());
        // already have a copy roadmap
        loTrinhRepository.findByHocVien_UserID(userID).ifPresent(copyLoTrinh -> loTrinhRepository.delete(copyLoTrinh));

        LoTrinh loTrinhMoi = new LoTrinh();
        loTrinhMoi.setLaKhuonMau(0);
        loTrinhMoi.setTrangThai(0);
        loTrinhMoi.setHocVien(hocVien);
        loTrinhRepository.save(loTrinhMoi);

        for (DauViecLoTrinh dauViec : danhSachDauViecMau) {
            DauViecLoTrinh dauViecMoi = new DauViecLoTrinh();
            dauViecMoi.setTenDauViec(dauViec.getTenDauViec());
            dauViecMoi.setStt(dauViec.getStt());
            dauViecMoi.setMoTa(dauViec.getMoTa());
            dauViecMoi.setLoTrinh(loTrinhMoi);
            dauViecRepository.save(dauViecMoi);
        }

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> editRoadmapDesc(UpdateRoadmapDescRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        LoTrinh loTrinh = loTrinhRepository.findByNguoiHuongDan_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!Objects.equals(loTrinh.getMoTa(), request.getMoTa())) {
            loTrinh.setMoTa(request.getMoTa());
        }
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> changeRoadmapStatus(String loTrinhID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        LoTrinh loTrinh = loTrinhRepository.findByNguoiHuongDan_UserID(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (loTrinh.getLaKhuonMau() == 0) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        if (loTrinh.getTrangThai() == 0) {
            loTrinh.setTrangThai(1);
        } else {
            loTrinh.setTrangThai(0);
        }
        return ResponseEntity.ok().build();
    }

}
