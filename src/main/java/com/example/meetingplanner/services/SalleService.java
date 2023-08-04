package com.example.meetingplanner.services;

import com.example.meetingplanner.entities.Salle;
import com.example.meetingplanner.repositories.SalleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SalleService {

    SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository){
        this.salleRepository = salleRepository;
    }

    public void createSalle(List<Salle> salles) {
        salleRepository.saveAll(salles);
    }

    public List<Salle> fetchAll(){
        return salleRepository.findAll();
    }

    public Salle findByID(UUID id) {
        return salleRepository.findById(id).orElseThrow();
    }

    public void delete(UUID id) {
        salleRepository.deleteById(id);
    }
}
