package com.hikari.roomsystem.repositories;

import com.hikari.roomsystem.entities.Room;
import com.hikari.roomsystem.entities.RoomAssignment;
import com.hikari.roomsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomAssignmentRepository extends JpaRepository<RoomAssignment, Long> {
    List<RoomAssignment> findByRoomId(Long roomId); // Все назначения для комнаты

    List<RoomAssignment> findByRoom(Room room);
    List<RoomAssignment> findByStudent(Student student);
    List<RoomAssignment> findByCheckOutDateIsNull();

}