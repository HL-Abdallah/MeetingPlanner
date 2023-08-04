package com.example.meetingplanner.services;

import com.example.meetingplanner.entities.Equipment;
import com.example.meetingplanner.entities.Meeting;
import com.example.meetingplanner.entities.Salle;
import com.example.meetingplanner.entities.TypeMeeting;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InitDatabase implements CommandLineRunner {


    EquipmentService equipmentService;
    ReservationService reservationService;
    MeetingService meetingService;
    SalleService salleService;

    public InitDatabase(
            EquipmentService equipmentService,
            ReservationService reservationService,
            MeetingService meetingService,
            SalleService salleService
    ) {
        this.equipmentService = equipmentService;
        this.reservationService = reservationService;
        this.meetingService = meetingService;
        this.salleService = salleService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Equipment> equipmentList = equipmentService.fetchAll();
        if (equipmentList.size() == 0) {
            log.info("Inserting dummy data for Equipments ...");
            initEquipments();
        } else {
            log.info("Data present for entity : Equipments , skipping data insert");
        }

        List<Salle> salleList  = salleService.fetchAll();
        if (salleList.size() == 0) {
            log.info("Inserting dummy data for Salles ...");
            initSalles();
        } else {
            log.info("Data present for entity : Salle , skipping data insert");
        }

        List<Meeting> meetingList  = meetingService.fetchAll();
        if (meetingList.size() == 0) {
            log.info("Inserting dummy data for Meetings ...");
            initMeeting();
        } else {
            log.info("Data present for entity : Meetings , skipping data insert");
        }
    }

    private void initMeeting() {

        List<Equipment> equipmentList = equipmentService.fetchAll();

        Meeting rs = Meeting.builder()
                .typeMeeting(TypeMeeting.RS)
                .requiredEquipments(null)
                .build();

        Meeting rc = Meeting.builder()
                .typeMeeting(TypeMeeting.RC)
                .requiredEquipments(
                        equipmentList.stream()
                                .filter(
                                        equipment -> Arrays.asList("TABLEAU","ECRAN","PIEUVRE").contains(equipment.getName())
                                ).collect(Collectors.toList())
                )
                .build();

        Meeting vc = Meeting.builder()
                .typeMeeting(TypeMeeting.VC)
                .requiredEquipments(
                        equipmentList.stream()
                                .filter(
                                        equipment -> Arrays.asList("WEBCAM","ECRAN","PIEUVRE").contains(equipment.getName())
                                ).collect(Collectors.toList())
                )
                .build();

        Meeting spec = Meeting.builder()
                .typeMeeting(TypeMeeting.SPEC)
                .requiredEquipments(
                        equipmentList.stream()
                                .filter(
                                        equipment -> Objects.equals("TABLEAU", equipment.getName())
                                ).collect(Collectors.toList())
                )
                .build();

        meetingService.createMeeting(Arrays.asList(rs,rc,vc,spec));
    }

    public void initEquipments() {

        Equipment ecran = new Equipment("ECRAN");
        Equipment tableau = new Equipment("TABLEAU");
        Equipment webcam = new Equipment("WEBCAM");
        Equipment pieuvre = new Equipment("PIEUVRE");

        List<Equipment> list = Arrays.asList(ecran, tableau, webcam, pieuvre);

        equipmentService.createEquipment(list);

    }

    public void initSalles() {

        List<Equipment> equipmentList = equipmentService.fetchAll();

        salleService.createSalle(
                Arrays.asList(
                        new Salle(
                                "E1001",
                                23,
                                null
                        ),
                        new Salle(
                                "E1002",
                                10,
                                equipmentList.stream()
                                        .filter(item ->
                                                Objects.equals("ECRAN", item.getName())
                                        )
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E1003",
                                8,
                                equipmentList.stream()
                                        .filter(item ->
                                                Objects.equals("PIEUVRE", item.getName())
                                        )
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E1004",
                                4,
                                equipmentList.stream()
                                        .filter(item ->
                                                Objects.equals("TABLEAU", item.getName())
                                        )
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E2001",
                                4,
                                null
                        ),
                        new Salle(
                                "E2002",
                                15,
                                equipmentList.stream()
                                        .filter(item ->
                                                Arrays.asList("PIEUVRE", "WEBCAM")
                                                        .contains(item.getName()))
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E2003",
                                7,
                                null
                        ),
                        new Salle(
                                "E2004",
                                9,
                                equipmentList.stream()
                                        .filter(equipment -> Objects.equals("TABLEAU", equipment.getName()))
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E3001",
                                13,
                                equipmentList.stream()
                                        .filter(equipment ->
                                                Arrays.asList("ECRAN", "WEBCAM", "PIEUVRE")
                                                        .contains(equipment.getName()))
                                        .collect(Collectors.toList())
                        ),
                        new Salle(
                                "E3002",
                                8,
                                null
                        ),
                        new Salle(
                                "E3003",
                                9,
                                equipmentList.stream()
                                        .filter(equipment ->
                                                Arrays.asList("ECRAN","PIEUVRE")
                                                        .contains(equipment.getName())
                                                ).collect(Collectors.toList())
                        ),
                        new Salle(
                                "E3004",
                                4,
                                null
                        )
                )
        );

    }
}
