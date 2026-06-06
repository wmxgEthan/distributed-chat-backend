package com.ethan.distributed_chat_backend.model;

import java.time.LocalDateTime;

public class Message {

    private Long id;
    private Long roomId;
    private String senderUsername;
    private String content;
    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(Long roomId, String senderUsername, String content) {
        this.roomId = roomId;
        this.senderUsername = senderUsername;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
