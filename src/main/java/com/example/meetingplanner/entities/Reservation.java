package com.example.meetingplanner.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Reservation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToOne(fetch = FetchType.EAGER)
    Meeting meeting;

    @OneToOne(fetch = FetchType.EAGER)
    Salle salle;

    LocalDateTime startDateTime;
    LocalDateTime endDateTime;

    Integer capacitePrevue;
}
