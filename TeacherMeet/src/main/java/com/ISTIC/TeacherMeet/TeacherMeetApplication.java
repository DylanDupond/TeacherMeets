package com.ISTIC.TeacherMeet;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Teacher Meet"
		)
)
public class TeacherMeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherMeetApplication.class, args);
	}

}
