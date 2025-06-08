package com.hikari.roomsystem.controllers;

import com.hikari.roomsystem.dto.RoomDto;
import com.hikari.roomsystem.entities.Room;
import com.hikari.roomsystem.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms/list"; // templates/rooms/list.html
    }

    @GetMapping("/new")
    public String showRoomForm(Model model) {
        model.addAttribute("room", new RoomDto());
        return "rooms/form"; // templates/rooms/form.html
    }

    @PostMapping
    public String createRoom(@ModelAttribute RoomDto dto) {
        roomService.createRoom(dto);
        return "redirect:/rooms";
    }

    @GetMapping("/{roomNumber}")
    public String viewRoom(@PathVariable String roomNumber, Model model) {
        model.addAttribute("room", roomService.getRoom(roomNumber));
        return "rooms/detail"; // templates/rooms/detail.html
    }
}
