package com.example.meetingplanner.controllers;

import com.example.meetingplanner.entities.Reservation;
import com.example.meetingplanner.services.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/reservation",produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.fetchAll();
    }

    @GetMapping("/{id}")
    public Reservation findByID(
            @PathVariable UUID id
    ) {
        return reservationService.findByID(id);
    }

    @PostMapping
    public ResponseEntity<Reservation> create(
            @RequestBody Reservation reservation
    ) {
        reservationService.createReservation(Collections.singletonList(reservation));
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> delete(
            @PathVariable UUID id
    ){
        reservationService.delete(id);
        return ResponseEntity.status(204).build();
    };

}
