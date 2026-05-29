package com.ethan.distributed_chat_backend.service;

import com.ethan.distributed_chat_backend.dto.LoginRequest;
import com.ethan.distributed_chat_backend.dto.RegisterRequest;
import com.ethan.distributed_chat_backend.model.User;
import com.ethan.distributed_chat_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(RegisterRequest request) {

        User existingUser = userRepository.findByUsername(request.getUsername());

        if (existingUser != null) {
            return null;
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        return userRepository.save(user);
    }

    public boolean login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername());

        if (user == null) {
            return false;
        }

        return user.getPassword().equals(request.getPassword());
    }
}