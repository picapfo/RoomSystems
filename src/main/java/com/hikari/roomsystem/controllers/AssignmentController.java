package com.hikari.roomsystem.controllers;

import com.hikari.roomsystem.dto.AssignmentRequest;
import com.hikari.roomsystem.entities.RoomAssignment;
import com.hikari.roomsystem.services.AssignmentService;
import com.hikari.roomsystem.services.RoomService;
import com.hikari.roomsystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;
    private final RoomService roomService;
    private final StudentService studentService;

    @GetMapping("/new")
    public String showAssignmentForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("assignmentRequest", new AssignmentRequest());
        return "assignments/form"; // templates/assignments/form.html
    }

    @PostMapping
    public String assignStudent(@ModelAttribute AssignmentRequest request) {
        assignmentService.assignStudent(request);
        return "redirect:/assignments";
    }

    @GetMapping
    public String listAssignments(Model model) {
        model.addAttribute("assignments", assignmentService.getAllAssignments());
        return "assignments/list"; // templates/assignments/list.html
    }

    @GetMapping("/room/{roomNumber}")
    public String getAssignmentsForRoom(@PathVariable String roomNumber, Model model) {
        model.addAttribute("assignments", assignmentService.getRoomAssignments(roomNumber));
        return "assignments/list"; // templates/assignments/list.html
    }
}
