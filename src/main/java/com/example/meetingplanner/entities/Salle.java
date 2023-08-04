package com.example.meetingplanner.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Salle extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;

    private Integer maxCapacity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "salle_equipment",
            joinColumns = @JoinColumn(name = "salle_uuid"),
            inverseJoinColumns = @JoinColumn(name = "equipment_uuid")
    )
    List<Equipment> equipmentsPresent;

    public Salle(String name,Integer maxCapacity,List<Equipment> equipmentsPresent){
        super();
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.equipmentsPresent = equipmentsPresent;
    }

}
