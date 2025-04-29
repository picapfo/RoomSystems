package com.hikari.roomsystem.repositories;

import com.hikari.roomsystem.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomNumber(String roomNumber); // Поиск по номеру комнаты
}