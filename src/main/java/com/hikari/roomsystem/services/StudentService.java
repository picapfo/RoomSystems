package com.hikari.roomsystem.services;

import com.hikari.roomsystem.dto.StudentDto;
import com.hikari.roomsystem.entities.Student;
import com.hikari.roomsystem.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    private final StudentRepository studentRepository;

    public Student createStudent(StudentDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setStudentId(dto.getStudentId());
        student.setFaculty(dto.getFaculty());
        return studentRepository.save(student);
    }

    public Student getStudent(String studentId) {
        return studentRepository.findByStudentId(studentId);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {return studentRepository.findAll();}
}
