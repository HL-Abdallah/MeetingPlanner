package com.example.meetingplanner.services;

import com.example.meetingplanner.entities.Meeting;
import com.example.meetingplanner.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MeetingService {

    MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository){
        this.meetingRepository = meetingRepository;
    }

    public void createMeeting(List<Meeting> meetings) {
        meetingRepository.saveAll(meetings);
    }

    public List<Meeting> fetchAll(){
        return meetingRepository.findAll();
    }

    public Meeting findByID(UUID id) {
        return meetingRepository.findById(id).orElseThrow();
    }

    public void delete(UUID id) {
        meetingRepository.deleteById(id);
    }
}
