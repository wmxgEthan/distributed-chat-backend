package com.ethan.distributed_chat_backend.repository;

import com.ethan.distributed_chat_backend.model.Room;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoomRepository {

    private final Map<Long, Room> rooms = new HashMap<>();
    Long nextId = 1L;

    public Room save(Room room) {
        room.setId(nextId);
        rooms.put(nextId, room);
        nextId++;

        return room;
    }

    public Room findById(Long id) {
        if (rooms.get(id) != null) {
            return rooms.get(id);
        }

        return null;
    }

    public Collection<Room> findAll() {
        return rooms.values();
    }
}
