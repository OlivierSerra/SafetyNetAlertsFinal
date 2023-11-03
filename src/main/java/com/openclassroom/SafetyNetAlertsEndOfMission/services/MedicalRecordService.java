package com.openclassroom.SafetyNetAlertsEndOfMission.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;

@Component
@Service
public class MedicalRecordService {

    private JsonReader jsonDataReader;
    public List<MedicalRecord> medicalRecords;

    public MedicalRecordService(JsonReader jsonDataReader) throws Exception {
        this.jsonDataReader = jsonDataReader;
        this.medicalRecords = this.jsonDataReader. getMedicalRecordsData();
    }
public MedicalRecordService() {
    }
/****************************  **************** */
   
/*
 * return all firestation after interrogation of firestation list
 
 */    
    public List<MedicalRecord> findAll() {
        return this.medicalRecords;
    }

 /*
  * add firestation in the list
  */
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
        return medicalRecord;   
    }

/*
 * used to delete a firestation
*/ 
    public MedicalRecord deleteMedicalRecords( MedicalRecord medicalRecord) {
        medicalRecords.remove(medicalRecord);
        return medicalRecord;
    }

/*
* return firestation if criterias match
*/
    public MedicalRecord updateMedicalRecord(String firstName, String lastName, MedicalRecord updatedMedicalRecord) {
         Optional<MedicalRecord> medicalRecordOptional = getMedicalRecord(firstName, lastName);

        if (medicalRecordOptional.isPresent()) {
            MedicalRecord currentMedicalRecordOptional = medicalRecordOptional.get();

            currentMedicalRecordOptional.setBirthdate(updatedMedicalRecord.getBirthdate());
            //currentMedicalRecordOptional.setMedications(updatedMedicalRecord.getMedications());
            //currentMedicalRecordOptional.setAllergies(updatedMedicalRecord.getAllergies());

            return saveMedicalRecord(currentMedicalRecordOptional);
        }
        return null;
    }

    private Optional<MedicalRecord> getMedicalRecord(String firstName, String lastName) {  
            for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                return Optional.of(medicalRecord); 
            }
        }
        return Optional.empty(); 
    }
}


