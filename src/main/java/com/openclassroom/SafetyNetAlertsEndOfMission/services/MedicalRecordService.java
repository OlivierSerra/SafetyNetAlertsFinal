package com.openclassroom.SafetyNetAlertsEndOfMission.services;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;
import com.openclassroom.SafetyNetAlertsEndOfMission.repository.MedicalRecordRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Data
@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService (MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

public List<MedicalRecord> findAll() {
    return medicalRecordRepository.findAll();
}

/*
* add person in the list
*/
public MedicalRecord save(MedicalRecord medicalRecord ) {
    MedicalRecord addedmedicalRecord = medicalRecordRepository.saveMedicalRecord(medicalRecord); 
    return addedmedicalRecord;
    }

/*
* used to delete a person
*/
public MedicalRecord delete(String firstName, String lastName) {
    return medicalRecordRepository.deleteMedicalRecord(firstName, lastName);
    }

/*
* return person if criterias match  
*/       
public MedicalRecord update(String firstName, String lastName, MedicalRecord medicalRecordToUpdate) {
    return medicalRecordRepository.updateMedicalRecord(firstName, lastName, medicalRecordToUpdate);   
    }

public MedicalRecord getmedicalRecord (String firstName, String lastName) {
    return medicalRecordRepository.medicalRecord(firstName, lastName);
}

}

