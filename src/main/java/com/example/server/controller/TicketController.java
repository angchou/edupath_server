package com.example.server.controller;

import com.example.server.dto.request.CreateTicketRequest;
import com.example.server.dto.response.TicketResponse;
import com.example.server.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@CrossOrigin(origins = "http://localhost:6969")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/get/my_ticket")
    @PreAuthorize("hasAnyRole('MENTOR', 'LEARNER')")
    public List<TicketResponse> getMyTickets() {
        return ticketService.getMyTickets();
    }

    @GetMapping("/get/waiting")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public List<TicketResponse> getWaitingTickets() {
        return ticketService.getWaitingTickets();
    }

    @GetMapping("/get/closed")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public List<TicketResponse> getClosedTickets() {
        return ticketService.getClosedTickets();
    }

    @GetMapping("/get/rejected")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public List<TicketResponse> getRejectedTickets() {
        return ticketService.getRejectedTickets();
    }

    @GetMapping("/get/expired")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public List<TicketResponse> getExpiredTickets() {
        return ticketService.getExpiredTickets();
    }

    @GetMapping("/get/near_expired")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public List<TicketResponse> getNearExpiredTickets() {
        return ticketService.getNearExpiredTickets();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('MENTOR', 'LEARNER')")
    public ResponseEntity<?> createTicket(@RequestBody CreateTicketRequest request) {
        return ticketService.createTicket(request);
    }

    @PatchMapping("/close/{ticketID}")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public ResponseEntity<?> rejectTicket(@PathVariable String ticketID) {
        return ticketService.closeTicket(ticketID);
    }

    @PatchMapping("/reject/{ticketID}")
    @PreAuthorize("hasAnyRole('SUPPORT')")
    public ResponseEntity<?> closeTicket(@PathVariable String ticketID) {
        return ticketService.rejectTicket(ticketID);
    }
}
