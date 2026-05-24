package com.example.server.service;

import com.example.server.dto.request.CreateTicketRequest;
import com.example.server.dto.response.TicketResponse;
import com.example.server.entities.NhanVien;
import com.example.server.entities.Ticket;
import com.example.server.entities.Users;
import com.example.server.repositories.NhanVienRepository;
import com.example.server.repositories.TicketRepository;
import com.example.server.repositories.UserRepository;
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
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Transactional
    public ResponseEntity<?> createTicket(CreateTicketRequest request) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Users user = userRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Ticket ticket = new Ticket();
        ticket.setMoTa(request.getMoTa());
        ticket.setLoaiTicket(request.getLoaiTicket());
        if (request.getLoaiTicket() == 1) {
            ticket.setDoUuTien(2);
        }
        else if (request.getLoaiTicket() == 2) {
            ticket.setDoUuTien(1);
        }
        else if (request.getLoaiTicket() == 3) {
            ticket.setDoUuTien(4);
        }
        else if (request.getLoaiTicket() == 4) {
            ticket.setDoUuTien(3);
        }
        ticket.setTrangThai(0);
        ticket.setNgayTao(LocalDate.now());
        ticket.setNgayHetHan(LocalDate.now().plusDays(14));
        ticket.setNguoiTao(user);
        ticketRepository.save(ticket);

        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> rejectTicket(String ticketID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Ticket ticket = ticketRepository.findById(ticketID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (ticket.getTrangThai() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        ticket.setTrangThai(2);
        ticket.setNhanVienXuLy(nhanVien);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<?> closeTicket(String ticketID) {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        Ticket ticket = ticketRepository.findById(ticketID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        NhanVien nhanVien = nhanVienRepository.findById(userID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (ticket.getTrangThai() != 0) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        ticket.setTrangThai(1);
        ticket.setNhanVienXuLy(nhanVien);
        return ResponseEntity.ok().build();
    }

    public List<TicketResponse> getMyTickets() {
        String userID = Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getName();
        List<Ticket> danhSachTicket = ticketRepository.findByNguoiTao_UserID(userID);
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

    public List<TicketResponse> getWaitingTickets() {
        List<Ticket> danhSachTicket = ticketRepository.findByTrangThaiAndNgayHetHanAfter(0, LocalDate.now());
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

    public List<TicketResponse> getClosedTickets() {
        List<Ticket> danhSachTicket = ticketRepository.findByTrangThai(1);
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

    public List<TicketResponse> getRejectedTickets() {
        List<Ticket> danhSachTicket = ticketRepository.findByTrangThai(2);
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

    public List<TicketResponse> getExpiredTickets() {
        List<Ticket> danhSachTicket = ticketRepository.findByNgayHetHanBefore(LocalDate.now());
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

    public List<TicketResponse> getNearExpiredTickets() {
        List<Ticket> danhSachTicket = ticketRepository.findByTrangThaiAndNgayHetHanBetween(0, LocalDate.now(), LocalDate.now().plusDays(2));
        return danhSachTicket.stream().map(
                ticket -> new TicketResponse(
                        ticket.getTicketID(),
                        ticket.getDoUuTien(),
                        ticket.getMoTa(),
                        ticket.getLoaiTicket(),
                        ticket.getTrangThai(),
                        ticket.getNgayTao(),
                        ticket.getNgayHetHan(),
                        ticket.getNguoiTao().getUserID(),
                        ticket.getNhanVienXuLy() != null ? ticket.getNhanVienXuLy().getUserID() : null
                )
        ).toList();
    }

}
