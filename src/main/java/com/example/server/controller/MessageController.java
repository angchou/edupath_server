package com.example.server.controller;

import com.example.server.dto.request.MessageRequest;
import com.example.server.dto.response.ConversationResponse;
import com.example.server.dto.response.CustomerResponse;
import com.example.server.dto.response.MessageResponse;
import com.example.server.entities.TinNhan;
import com.example.server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:6969")
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/get/mentor")
    @PreAuthorize("hasRole('LEARNER')")
    public List<CustomerResponse> getMyMentor() {
        return messageService.getMyMentor();
    }

    @GetMapping("/get/student")
    @PreAuthorize("hasRole('MENTOR')")
    public List<CustomerResponse> getMyStudents() {
        return messageService.getMyStudents();
    }

    @GetMapping("/get/conversation/{targetID}")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public ConversationResponse getConversation(@PathVariable String targetID) {
        return messageService.getConversation(targetID);
    }

    @GetMapping("/get/message/conversation/{cuocTroChuyenID}")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public List<MessageResponse> getMessagesOfConversation(@PathVariable String cuocTroChuyenID) {
        return messageService.getMessagesOfConversation(cuocTroChuyenID);
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('LEARNER', 'MENTOR')")
    public MessageResponse createMessage(@RequestBody MessageRequest request, Principal principal) {
        String userID = principal.getName();

        return messageService.responseCreateMessage(request, userID);
    }

}
