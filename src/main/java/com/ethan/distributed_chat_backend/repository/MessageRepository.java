package com.ethan.distributed_chat_backend.repository;

import com.ethan.distributed_chat_backend.model.Message;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MessageRepository {

    private final Map<Long, List<Message>> messagesByRoom = new HashMap<>();

    private Long nextId = 1L;

    public Message save(Long roomId, Message message) {

        message.setId(nextId++);

        messagesByRoom
                .computeIfAbsent(roomId, k -> new ArrayList<>())
                .add(message);

        return message;
    }

    public List<Message> getMessagesForRoom(Long roomId) {
        return messagesByRoom.getOrDefault(roomId, new ArrayList<>());
    }
}
