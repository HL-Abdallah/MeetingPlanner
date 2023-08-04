package com.example.meetingplanner.controllers;

import com.example.meetingplanner.entities.Equipment;
import com.example.meetingplanner.services.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/equipment",produces = MediaType.APPLICATION_JSON_VALUE)
public class EquipmentController {

    EquipmentService equipmentService;

    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Operation(summary = "this is summary",
    description = "this is desc"

    )
    @GetMapping
    public List<Equipment> findAll() {
        return equipmentService.fetchAll();
    }

    @GetMapping("/{id}")
    public Equipment findByID(
            @PathVariable UUID id
    ) {
        return equipmentService.findByID(id);
    }

    @PostMapping
    public ResponseEntity<Equipment> create(
            @RequestBody Equipment equipment
    ) {
        equipmentService.createEquipment(Collections.singletonList(equipment));
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipment> delete(
            @PathVariable UUID id
    ){
        equipmentService.delete(id);
        return ResponseEntity.status(204).build();
    };

}
