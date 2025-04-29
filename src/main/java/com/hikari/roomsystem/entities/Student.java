package com.hikari.roomsystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public RoomAssignment getRoomAssignment() {
        return roomAssignment;
    }

    public void setRoomAssignment(RoomAssignment roomAssignment) {
        this.roomAssignment = roomAssignment;
    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String studentId; // Номер студенческого билета

    @Column(nullable = false)
    private String faculty;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private RoomAssignment roomAssignment;
}
