package com.example.meetingplanner.controllers;

import com.example.meetingplanner.entities.Salle;
import com.example.meetingplanner.services.SalleService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/salle",produces = MediaType.APPLICATION_JSON_VALUE)
public class SalleController {

    SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping
    public List<Salle> findAll() {
        return salleService.fetchAll();
    }

    @GetMapping("/{id}")
    public Salle findByID(
            @PathVariable UUID id
    ) {
        return salleService.findByID(id);
    }

    @PostMapping
    public ResponseEntity<Salle> create(
            @RequestBody Salle salle
    ) {
        salleService.createSalle(Collections.singletonList(salle));
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Salle> delete(
            @PathVariable UUID id
    ){
        salleService.delete(id);
        return ResponseEntity.status(204).build();
    };

}
