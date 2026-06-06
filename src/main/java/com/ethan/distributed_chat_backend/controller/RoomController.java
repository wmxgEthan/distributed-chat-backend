package com.ethan.distributed_chat_backend.controller;

import com.ethan.distributed_chat_backend.dto.CreateRoomRequest;
import com.ethan.distributed_chat_backend.model.Room;
import com.ethan.distributed_chat_backend.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public Room newRoom(@RequestBody CreateRoomRequest request) {
        return roomService.createRoom(request);
    }

    @GetMapping
    public Collection<Room> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id) {
        return roomService.getRoom(id);
    }
}
