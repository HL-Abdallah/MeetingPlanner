package com.example.meetingplanner.repositories;

import com.example.meetingplanner.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
}
