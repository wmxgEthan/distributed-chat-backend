package com.ethan.distributed_chat_backend;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private List<Message> messages =
            new ArrayList<>();

    public void save(Message message) {
        messages.add(message);
    }

    public List<Message> getAll() {
        return messages;
    }
}