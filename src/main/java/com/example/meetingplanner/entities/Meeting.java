package com.example.meetingplanner.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Meeting extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private TypeMeeting typeMeeting;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "meeting_equipment",
            joinColumns = @JoinColumn(name = "meeting_uuid"),
            inverseJoinColumns = @JoinColumn(name = "equipment_uuid")
    )
    private List<Equipment> requiredEquipments;

}
