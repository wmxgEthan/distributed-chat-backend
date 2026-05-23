package com.ethan.distributed_chat_backend;

public class Message {

    public String username;
    public String content;

    public Message(){}

    public Message(String username, String content) {
        this.username = username;
        this.content = content;
    }
}