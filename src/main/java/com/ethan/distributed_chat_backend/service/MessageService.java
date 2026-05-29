package com.ethan.distributed_chat_backend.service;

import com.ethan.distributed_chat_backend.model.Message;
import com.ethan.distributed_chat_backend.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public Message processMessage(Message message) {
        message.content =
                message.content.toUpperCase();
        repository.save(message);
        return message;
    }

    public List<Message> getMessages() {
        return repository.getAll();
    }
}