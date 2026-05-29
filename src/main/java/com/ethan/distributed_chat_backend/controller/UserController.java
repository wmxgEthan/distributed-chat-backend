package com.ethan.distributed_chat_backend.controller;

import com.ethan.distributed_chat_backend.dto.LoginRequest;
import com.ethan.distributed_chat_backend.dto.RegisterRequest;
import com.ethan.distributed_chat_backend.model.User;
import com.ethan.distributed_chat_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}