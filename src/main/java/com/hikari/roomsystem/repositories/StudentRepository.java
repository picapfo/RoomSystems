package com.hikari.roomsystem.repositories;
import com.hikari.roomsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentId(String studentId); // Поиск по номеру студенческого
}