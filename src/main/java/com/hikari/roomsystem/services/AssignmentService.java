package com.hikari.roomsystem.services;

import com.hikari.roomsystem.dto.AssignmentRequest;
import com.hikari.roomsystem.entities.Room;
import com.hikari.roomsystem.entities.RoomAssignment;
import com.hikari.roomsystem.entities.Student;
import com.hikari.roomsystem.repositories.RoomAssignmentRepository;
import com.hikari.roomsystem.repositories.RoomRepository;
import com.hikari.roomsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentService {
    private final RoomAssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    public AssignmentService(RoomAssignmentRepository assignmentRepository, StudentRepository studentRepository, RoomRepository roomRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
    }

    public RoomAssignment assignStudent(AssignmentRequest request) {
        Student student = studentRepository.findByStudentId(request.getStudentId());
        Room room = roomRepository.findByRoomNumber(request.getRoomNumber());

        if (student == null || room == null) {
            throw new IllegalArgumentException("Invalid student or room");
        }

        List<RoomAssignment> assignments = assignmentRepository.findByRoomId(room.getId());
        if (assignments.size() >= room.getCapacity()) {
            try {
                throw new RoomFullException("Room " + room.getRoomNumber() + " is full");
            } catch (RoomFullException e) {
                throw new RuntimeException(e);
            }
        }

        RoomAssignment assignment = new RoomAssignment();
        assignment.setStudent(student);
        assignment.setRoom(room);
        assignment.setCheckInDate(request.getCheckInDate());
        assignment.setCheckOutDate(request.getCheckOutDate());

        return assignmentRepository.save(assignment);
    }

    public List<RoomAssignment> getRoomAssignments(String roomNumber) {
        Room room = roomRepository.findByRoomNumber(roomNumber);
        return assignmentRepository.findByRoomId(room.getId());
    }
}
