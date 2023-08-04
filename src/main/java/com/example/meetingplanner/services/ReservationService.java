package com.example.meetingplanner.services;

import com.example.meetingplanner.entities.Reservation;
import com.example.meetingplanner.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public void createReservation(List<Reservation> reservations) {
        reservationRepository.saveAll(reservations);
    }

    public List<Reservation> fetchAll(){
        return reservationRepository.findAll();
    }

    public Reservation findByID(UUID id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public void delete(UUID id) {
        reservationRepository.deleteById(id);
    }
}
