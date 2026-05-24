package com.example.server.repositories;

import com.example.server.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    List<Ticket> findByNguoiTao_UserID(String userID);
    List<Ticket> findByTrangThai(int trangThai);
    List<Ticket> findByNgayHetHanBefore(LocalDate date);
    List<Ticket> findByTrangThaiAndNgayHetHanBetween(int trangThai, LocalDate from, LocalDate to);
    List<Ticket> findByTrangThaiAndNgayHetHanAfter(int trangThai, LocalDate date);
    List<Ticket> findByTicketIDAndTrangThai(String ticketID, int trangThai);
}
