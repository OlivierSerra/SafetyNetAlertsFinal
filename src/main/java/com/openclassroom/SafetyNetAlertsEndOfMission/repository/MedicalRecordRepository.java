package com.openclassroom.SafetyNetAlertsEndOfMission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long>{
    
}
