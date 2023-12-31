package com.openclassroom.SafetyNetAlertsEndOfMission.services;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;
import com.openclassroom.SafetyNetAlertsEndOfMission.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Data
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

public List<Person> findAll() {
    return personRepository.findAll();
}

/*
* add person in the list
*/
public Person save(Person person) {
    Person addedPerson = personRepository.save(person); 
    return addedPerson;
    }

/*
* used to delete a person
*/
public Person delete(String firstName, String lastName) {
    return personRepository.deletePerson(firstName, lastName);
    }

/*
* return person if criterias match  
*/       
public Person update(String firstName, String lastName, Person PersonToUpdate) {
    return personRepository.updatePerson(firstName, lastName, PersonToUpdate);   
    }

public Person getPerson(String firstName, String lastName) {
    return personRepository.person(firstName, lastName);
}

}

