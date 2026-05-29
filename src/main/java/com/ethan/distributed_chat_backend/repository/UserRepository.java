package com.ethan.distributed_chat_backend.repository;

import com.ethan.distributed_chat_backend.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    public User save(User user) {
        user.setId(nextId);
        users.put(nextId, user);
        nextId++;

        return user;
    }

    public User findByUsername(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public Collection<User> findAll() {
        return users.values();
    }
}