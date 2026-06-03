package com.ethan.distributed_chat_backend.service;

import com.ethan.distributed_chat_backend.dto.CreateMessageRequest;
import com.ethan.distributed_chat_backend.model.Message;
import com.ethan.distributed_chat_backend.model.Room;
import com.ethan.distributed_chat_backend.repository.MessageRepository;
import com.ethan.distributed_chat_backend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final RoomRepository roomRepository;

    public MessageService(MessageRepository messageRepository,
                          RoomRepository roomRepository) {
        this.messageRepository = messageRepository;
        this.roomRepository = roomRepository;
    }

    public Message createMessage(Long roomId,
                                 CreateMessageRequest request) {

        Room room = roomRepository.findById(roomId);

        if (room == null) {
            return null;
        }

        Message message = new Message();

        message.setRoomId(roomId);
        message.setSenderUsername(request.getSenderUsername());
        message.setContent(request.getContent());
        message.setTimestamp(LocalDateTime.now());

        return messageRepository.save(roomId, message);
    }

    public List<Message> getMessagesForRoom(Long roomId) {
        return messageRepository.getMessagesForRoom(roomId);
    }
}