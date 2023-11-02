package com.openclassroom.SafetyNetAlertsEndOfMission.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.SafetyNetAlertsEndOfMission.services.MedicalRecordService;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;

@RestController
@ComponentScan(basePackages = "com.openclassroom.SafetyNetAlertsEndOfMission")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping("/medicalRecord") 
    public List<MedicalRecord> medicalRecord() {
    return medicalRecordService.findAll();
        }

    @PostMapping("/medicalRecord")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
    return medicalRecordService.saveMedicalRecord(medicalRecord);
}

    @DeleteMapping("/medicalRecord")
    public MedicalRecord deleteMedicalRecord(@RequestBody MedicalRecord medicalRecord) {   
    return medicalRecordService.deleteMedicalRecords(medicalRecord);
        }

    @PutMapping("/medicalRecord/{firstName}/{lastName}")
    public MedicalRecord updateMedicalRecord(
        @PathVariable("firstName") String firstName,
        @PathVariable("lastName") String lastName,
        @RequestBody MedicalRecord updatedMedicalRecord) {
        return medicalRecordService.updateMedicalRecord(firstName, lastName, updatedMedicalRecord);        
    }
 
}
