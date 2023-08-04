package com.example.meetingplanner.repositories;

import com.example.meetingplanner.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalleRepository extends JpaRepository<Salle, UUID> {

}
