package com.openclassroom.SafetyNetAlertsEndOfMission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.openclassroom.SafetyNetAlertsEndOfMission")
public class SafetyNetAlertsEndOfMissionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetAlertsEndOfMissionApplication.class, args);
	}

}
