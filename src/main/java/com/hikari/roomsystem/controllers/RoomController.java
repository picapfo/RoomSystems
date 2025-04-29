package com.hikari.roomsystem.controllers;

import com.hikari.roomsystem.dto.RoomDto;
import com.hikari.roomsystem.entities.Room;
import com.hikari.roomsystem.services.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@RequestBody RoomDto dto) {
        return roomService.createRoom(dto);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomNumber}")
    public Room getRoom(@PathVariable String roomNumber) {
        return roomService.getRoom(roomNumber);
    }
}
