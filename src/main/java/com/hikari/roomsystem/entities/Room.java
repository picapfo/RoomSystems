package com.hikari.roomsystem.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber; // Номер комнаты (например, "101A")

    @Column(nullable = false)
    private int capacity; // Вместимость (количество мест)

    @Column(nullable = false)
    private String floor; // Этаж

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomAssignment> assignments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public List<RoomAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<RoomAssignment> assignments) {
        this.assignments = assignments;
    }
}
