package com.example.meetingplanner.services;

import com.example.meetingplanner.entities.Equipment;
import com.example.meetingplanner.repositories.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EquipmentService {

    EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    public void createEquipment(List<Equipment> equipments) {
        equipmentRepository.saveAll(equipments);
    }

    public List<Equipment> fetchAll(){
       return equipmentRepository.findAll();
    }

    public Equipment findByID(UUID id) {
        return equipmentRepository.findById(id).orElseThrow();
    }

    public void delete(UUID id) {
        equipmentRepository.deleteById(id);
    }
}
