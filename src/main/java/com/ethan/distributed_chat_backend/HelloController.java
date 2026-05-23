package com.ethan.distributed_chat_backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class HelloController {

    private MessageService service;

    public HelloController(MessageService service) {
        this.service = service;
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return service.getMessages();
    }

    @PostMapping("/echo")
    public Message echo(@RequestBody Message message) {
        return service.processMessage(message);
    }
}