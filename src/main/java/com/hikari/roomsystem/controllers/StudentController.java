package com.hikari.roomsystem.controllers;

import com.hikari.roomsystem.dto.StudentDto;
import com.hikari.roomsystem.entities.Student;
import com.hikari.roomsystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list"; // templates/students/list.html
    }

    @GetMapping("/new")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new StudentDto());
        return "students/form"; // templates/students/form.html
    }

    @PostMapping
    public String createStudent(@ModelAttribute StudentDto studentDto) {
        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    @GetMapping("/{studentId}")
    public String viewStudent(@PathVariable String studentId, Model model) {
        model.addAttribute("student", studentService.getStudent(studentId));
        return "students/detail"; // templates/students/detail.html
    }

    @PostMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

