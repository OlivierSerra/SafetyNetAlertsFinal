package com.openclassroom.SafetyNetAlertsEndOfMission.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonReader {
    
    List<Person> persons = new ArrayList<>();
    List<Firestation> firestations = new ArrayList<>();
    List<MedicalRecord> medicalRecords = new ArrayList<>();
    String filePath = "src/main/resources/data.json";

    Content content;

    public JsonReader(){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File(this.filePath);
        try{
            content = objectMapper.readValue(jsonFile, Content.class);
            this.persons = this.content.getPersons();
            this.firestations = this.content.getFirestations();
            this.medicalRecords = this.content.getMedicalrecords();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getPersonsData(){
        return this.persons;
    }

    public List<Firestation> getFirestationsData() {
        return this.firestations;
    }

    public List<MedicalRecord> getMedicalRecordsData() {
        return this.medicalRecords;
    }

}
