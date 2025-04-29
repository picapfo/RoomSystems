package com.hikari.roomsystem.controllers;

import com.hikari.roomsystem.dto.AssignmentRequest;
import com.hikari.roomsystem.entities.RoomAssignment;
import com.hikari.roomsystem.services.AssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping
    public RoomAssignment assignStudent(@RequestBody AssignmentRequest request) {
        return assignmentService.assignStudent(request);
    }

    @GetMapping("/room/{roomNumber}")
    public List<RoomAssignment> getAssignmentsForRoom(@PathVariable String roomNumber) {
        return assignmentService.getRoomAssignments(roomNumber);
    }
}
