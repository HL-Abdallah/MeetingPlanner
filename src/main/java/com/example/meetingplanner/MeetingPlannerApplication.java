package com.example.meetingplanner;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Meeting Planner",
                description = "les docs sont générés automatiquement",
                contact = @Contact(
                        name = "Abdallah Hameur Lain",
                        email = "hameurlain.abdallah@gmail.com",
                        url = "https://www.linkedin.com/in/hameurlain-abdallah/"
                ),
                version = "1.0.alpha"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8082",
                        description = "local : Intellij IDEA"
                ),
                @Server(
                        url = "http://aws.someurl.com",
                        description = "Remote docker thing"
                )
        }
)
@EnableJpaAuditing
public class MeetingPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingPlannerApplication.class, args);
    }

}
