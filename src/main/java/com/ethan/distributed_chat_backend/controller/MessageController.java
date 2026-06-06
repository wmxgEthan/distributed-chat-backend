package com.ethan.distributed_chat_backend.controller;

import com.ethan.distributed_chat_backend.dto.CreateMessageRequest;
import com.ethan.distributed_chat_backend.model.Message;
import com.ethan.distributed_chat_backend.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/{roomId}/messages")
    public Message createMessage(
            @PathVariable Long roomId,
            @RequestBody CreateMessageRequest request) {

        return messageService.createMessage(roomId, request);
    }

    @GetMapping("/{roomId}/messages")
    public List<Message> getMessages(
            @PathVariable Long roomId) {

        return messageService.getMessagesForRoom(roomId);
    }
}
