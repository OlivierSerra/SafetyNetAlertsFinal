package com.openclassroom.SafetyNetAlertsEndOfMission.repository;

//import org.slf4j.Logger;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
//import org.springframework.web.client.RestTemplate;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;

//import lombok.extern.slf4j.Slf4j;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

//@Slf4j
@Component
@Repository
public class PersonRepository {

    public List<Person> persons;
    private JsonReader jsonDataReader;
   Content content;

    public PersonRepository(JsonReader jsonDataReader) throws Exception {
        this.jsonDataReader = jsonDataReader;
        this.persons = this.jsonDataReader.getPersonsData();
    }

/* 
 * return all person after interrogation of list Person
*/
    public List<Person> findAll() {
        return this.persons;
    }

/* 
 * save person object  
*/
    public Person save(Person person) {
        persons.add(person);
        return person;
        }

/*
 * delete person 
*/
    public Person delete(Person person) {
        persons.remove(person);
        return person;
        }

/*
 * return person if criterias match  
 * 
 */
    public Optional<Person> getPerson(String firstName, String lastName) {
        for (Person person : persons) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                return Optional.of(person); 
            }
        }
        return Optional.empty(); 
    }
}
