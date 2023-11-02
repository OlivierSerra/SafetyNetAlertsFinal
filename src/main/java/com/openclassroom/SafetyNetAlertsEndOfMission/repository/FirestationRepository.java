package com.openclassroom.SafetyNetAlertsEndOfMission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, Long>{
}