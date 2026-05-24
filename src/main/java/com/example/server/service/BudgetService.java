package com.example.server.service;

import com.example.server.dto.request.CreateBudgetRequest;
import com.example.server.dto.response.BudgetResponse;
import com.example.server.dto.response.BudgetTypeResponse;
import com.example.server.entities.LoaiNganSach;
import com.example.server.entities.NganSach;
import com.example.server.repositories.LoaiNganSachRepository;
import com.example.server.repositories.NganSachRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BudgetService {
    @Autowired
    private LoaiNganSachRepository loaiNganSachRepository;
    @Autowired
    private NganSachRepository nganSachRepository;

    public List<BudgetTypeResponse> getBudgetTypes() {
        List<LoaiNganSach> danhSach = loaiNganSachRepository.findAll();
        return danhSach.stream().map(
                lns -> new BudgetTypeResponse(
                        lns.getLoaiNganSachID(),
                        lns.getTenLNS()
                )
        ).toList();
    }

    public List<BudgetResponse> getAllBudgets() {
        List<NganSach> danhSach = nganSachRepository.findAll();
        return danhSach.stream().map(
                ns -> new BudgetResponse(
                        ns.getNganSachID(),
                        ns.getLoaiNganSach().getLoaiNganSachID(),
                        ns.getNgayBatDau(),
                        ns.getNgayKetThuc(),
                        ns.getTriGia()
                )
        ).toList();
    }

    @Transactional
    public void createBudget(CreateBudgetRequest request) {
        LoaiNganSach loaiNganSach = loaiNganSachRepository.findById(request.getLoaiNganSachID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        NganSach nganSach = new NganSach();
        nganSach.setLoaiNganSach(loaiNganSach);
        nganSach.setNgayBatDau(request.getNgayBatDau());
        nganSach.setNgayKetThuc(request.getNgayKetThuc());
        nganSach.setTriGia(request.getTriGia());
        nganSachRepository.save(nganSach);
    }
}
