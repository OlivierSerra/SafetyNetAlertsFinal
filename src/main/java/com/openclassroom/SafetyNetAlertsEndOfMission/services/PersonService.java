package com.openclassroom.SafetyNetAlertsEndOfMission.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;


@Component
@Service
public class PersonService {

    private JsonReader jsonDataReader;
    public List<Person> persons;

    public PersonService(JsonReader jsonDataReader) throws Exception {
        this.jsonDataReader = jsonDataReader;
        this.persons = this.jsonDataReader.getPersonsData();
        }

        /********************* endpoint/person   ********************/

/* 
* return all person after interrogation of list Person
*/
    public List<Person> findAll() {
        return this.persons;
    }

/*
* add person in the list
*/
    public Person save(Person person) {
        persons.add(person);
        return person;
        }

/*
* used to delete a person
*/
    public Person delete(Person person) {
        persons.remove(person);
        return person;
        }

/*
* return person if criterias match  
*/       
    public Person updatePerson(String firstName, String lastName, Person updatedPerson) {
        Optional<Person> personOptional = getPerson(firstName, lastName);

        if (personOptional.isPresent()) {
            Person currentPerson = personOptional.get();

            currentPerson.setAddress(updatedPerson.getAddress());
            currentPerson.setCity(updatedPerson.getCity());
            currentPerson.setZip(updatedPerson.getZip());
            currentPerson.setPhone(updatedPerson.getPhone());
            currentPerson.setEmail(updatedPerson.getEmail());

            return save(currentPerson);
        }

        return null;
    }
/* 
 * return person if criterias match  
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







