package com.example.meetingplanner.repositories;

import com.example.meetingplanner.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeetingRepository extends JpaRepository<Meeting, UUID> {
}
