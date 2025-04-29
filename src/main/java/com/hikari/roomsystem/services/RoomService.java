package com.hikari.roomsystem.services;

import com.hikari.roomsystem.dto.RoomDto;
import com.hikari.roomsystem.entities.Room;
import com.hikari.roomsystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    public Room createRoom(RoomDto dto) {
        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setCapacity(dto.getCapacity());
        room.setFloor(dto.getFloor());
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoom(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }
}
