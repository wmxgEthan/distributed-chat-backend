package com.ethan.distributed_chat_backend.service;

import com.ethan.distributed_chat_backend.model.Room;
import com.ethan.distributed_chat_backend.repository.RoomRepository;
import com.ethan.distributed_chat_backend.dto.CreateRoomRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(CreateRoomRequest request) {

        if (request.getName() == null ||
                request.getName().isBlank()) {
            return null;
        }

        Room newRoom = new Room();
        newRoom.setName(request.getName());
        return roomRepository.save(newRoom);
    }

    public Room getRoom(Long id) {
        return roomRepository.findById(id);
    }

    public Collection<Room> getRooms() {
        return roomRepository.findAll();
    }
}
