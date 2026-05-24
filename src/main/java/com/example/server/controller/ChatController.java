package com.example.server.controller;

import com.example.server.dto.request.MessageRequest;
import com.example.server.dto.response.MessageResponse;
import com.example.server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat.sendMessage")
    public void handleIncomingMessage(@Payload MessageRequest request, Principal principal) {
        String userID = principal.getName();

        MessageResponse savedMessage = messageService.responseCreateMessage(request, userID);

        String destination = "/topic/room." + savedMessage.getCuocTroChuyenID();

        messagingTemplate.convertAndSend(destination, savedMessage);
    }
}