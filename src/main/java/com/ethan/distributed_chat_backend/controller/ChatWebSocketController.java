package com.ethan.distributed_chat_backend.controller;

import com.ethan.distributed_chat_backend.dto.CreateMessageRequest;
import com.ethan.distributed_chat_backend.model.Message;
import com.ethan.distributed_chat_backend.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWebSocketController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatWebSocketController(MessageService messageService, SimpMessagingTemplate messagingTemplate) {

        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/send")
    public void sendMessage(CreateMessageRequest request) {

        Message savedMessage = messageService.createMessage(request.getRoomId(), request);

        if (savedMessage == null) {
            return;
        }

        messagingTemplate.convertAndSend("/topic/rooms/" + request.getRoomId(), savedMessage);
    }
}