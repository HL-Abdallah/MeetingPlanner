package com.example.meetingplanner.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Equipment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "requiredEquipments")
    List<Meeting> meetingsList;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "equipmentsPresent")
    List<Salle> sallesListe;

    public Equipment(String name) {
        super();
        this.name = name;
    }
}
