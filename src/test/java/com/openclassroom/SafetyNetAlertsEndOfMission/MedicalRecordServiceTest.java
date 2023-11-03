package com.openclassroom.SafetyNetAlertsEndOfMission;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.MedicalRecordService;

@SpringBootTest
public class MedicalRecordServiceTest {
    private MedicalRecordService medicalRecordService = new MedicalRecordService();


    @Test    
    public void testUpdateMedicalRecord() {
        
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecord updatedMedicalRecord = new MedicalRecord();
        updatedMedicalRecord.setBirthdate("01/01/1990");
        updatedMedicalRecord.setMedications("aznol:350mg", "hydrapermazol:100mg");
        updatedMedicalRecord.setAllergies("nillacilan");

        // Appelez la méthode updateMedicalRecord
        MedicalRecord result = medicalRecordService.updateMedicalRecord(firstName, lastName, updatedMedicalRecord);

        // Vérifiez si le dossier médical a été mis à jour correctement
        assertNotNull(result);

        // Vérifiez si les données du dossier médical sont correctes
        assertEquals("01/01/1990", result.getBirthdate());
        assertEquals("aznol:350mg, hydrapermazol:100mg", result.getMedications());
        assertEquals("nillacilan", result.getAllergies());
    }

    @Test    
    public void testSaveMedicalRecord() {
        
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecord savedMedicalRecord = new MedicalRecord();
        savedMedicalRecord.setBirthdate("01/01/1990");
        savedMedicalRecord.setMedications("aznol:350mg", "hydrapermazol:100mg");
        savedMedicalRecord.setAllergies("nillacilan");

        // Appelez la méthode updateMedicalRecord
        MedicalRecord result = medicalRecordService.saveMedicalRecord(savedMedicalRecord);

        // Vérifiez si le dossier médical a été mis à jour correctement
        assertNotNull(result);

        // Vérifiez si les données du dossier médical sont correctes
        assertEquals("01/01/1990", result.getBirthdate());
        assertEquals("aznol:350mg, hydrapermazol:100mg", result.getMedications());
        assertEquals("nillacilan", result.getAllergies());
    }


    @Test    
    public void testDeleteMedicalRecord() {
        
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecord deleteMedicalRecord = new MedicalRecord();
        deleteMedicalRecord.setBirthdate("01/01/1990");
        deleteMedicalRecord.setMedications("aznol:350mg", "hydrapermazol:100mg");
        deleteMedicalRecord.setAllergies("nillacilan");

        // Appelez la méthode updateMedicalRecord
        MedicalRecord result = medicalRecordService.deleteMedicalRecords(deleteMedicalRecord);

        // Vérifiez si le dossier médical a été mis à jour correctement
        assertNotNull(result);

        // Vérifiez si les données du dossier médical sont correctes
        assertEquals("01/01/1990", result.getBirthdate());
        assertEquals("aznol:350mg, hydrapermazol:100mg", result.getMedications());
        assertEquals("nillacilan", result.getAllergies());
    }


    @Test    
    public void testAddMedicalRecord() {
        
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecord addMedicalRecord = new MedicalRecord();
        addMedicalRecord.setBirthdate("01/01/1990");
        addMedicalRecord.setMedications("aznol:350mg", "hydrapermazol:100mg");
        addMedicalRecord.setAllergies("nillacilan");

        // Appelez la méthode updateMedicalRecord
        MedicalRecord result = medicalRecordService.deleteMedicalRecords(addMedicalRecord);

        // Vérifiez si le dossier médical a été mis à jour correctement
        assertNotNull(result);

        // Vérifiez si les données du dossier médical sont correctes
        assertEquals("01/01/1990", result.getBirthdate());
        assertEquals("aznol:350mg, hydrapermazol:100mg", result.getMedications());
        assertEquals("nillacilan", result.getAllergies());
    }
    
    @Test    
    public void testGetMedicalRecord() {
        
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecord getMedicalRecord = new MedicalRecord();
        getMedicalRecord.setBirthdate("01/01/1990");
        getMedicalRecord.setMedications("aznol:350mg", "hydrapermazol:100mg");
        getMedicalRecord.setAllergies("nillacilan");

        // Appelez la méthode updateMedicalRecord
        MedicalRecord result = medicalRecordService.deleteMedicalRecords(getMedicalRecord);

        // Vérifiez si le dossier médical a été mis à jour correctement
        assertNotNull(result);

        // Vérifiez si les données du dossier médical sont correctes
        assertEquals("01/01/1990", result.getBirthdate());
        assertEquals("aznol:350mg, hydrapermazol:100mg", result.getMedications());
        assertEquals("nillacilan", result.getAllergies());
    }
    
}

