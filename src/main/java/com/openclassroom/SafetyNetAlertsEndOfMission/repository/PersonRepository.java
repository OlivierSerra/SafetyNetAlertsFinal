package com.openclassroom.SafetyNetAlertsEndOfMission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}

