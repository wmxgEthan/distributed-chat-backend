package com.ethan.distributed_chat_backend.dto;

public class CreateMessageRequest {

    private String senderUsername;
    private String content;
    private Long roomId;

    public CreateMessageRequest() {
    }

    public Long getRoomId() { return roomId; }

    public void setRoomId(Long roomId) { this.roomId = roomId; }

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
}
