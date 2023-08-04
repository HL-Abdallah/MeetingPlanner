package com.example.meetingplanner.controllers;

import com.example.meetingplanner.entities.Meeting;
import com.example.meetingplanner.services.MeetingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/meeting",produces = MediaType.APPLICATION_JSON_VALUE)
public class MeetingController {

    MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public List<Meeting> findAll() {
        return meetingService.fetchAll();
    }

    @GetMapping("/{id}")
    public Meeting findByID(
            @PathVariable UUID id
    ) {
        return meetingService.findByID(id);
    }

    @PostMapping
    public ResponseEntity<Meeting> create(
            @RequestBody Meeting meeting
    ) {
        meetingService.createMeeting(Collections.singletonList(meeting));
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Meeting> delete(
            @PathVariable UUID id
    ){
        meetingService.delete(id);
        return ResponseEntity.status(204).build();
    };

}
