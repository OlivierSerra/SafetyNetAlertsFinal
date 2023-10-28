package com.openclassroom.SafetyNetAlertsEndOfMission.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.SafetyNetAlertsEndOfMission.repository.PersonRepository;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;


@RestController
public class PersonController {


    @Autowired
    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

/* 
* This method is used to find the list with all the people  
*/
    @GetMapping("/person") 
        public List<Person>persons() {
            return personRepository.findAll();
        }
 
/*  
 * This méthod is used to add one person in the list
*/
    @PostMapping("/person")
        public Person addPerson(@RequestBody Person person) {
            return personRepository.save(person);
        }
/*
 * This method is used to delete one person in the list
 */
    @DeleteMapping("/person")
	    public Person deletePerson(@RequestBody Person person) {   
            return personRepository.delete(person);
        }
    
/*This method is used to update person data
 */         
    @PutMapping("/person/{firstName}/{lastName}")
        public Person updatePerson(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @RequestBody Person updatedPerson) {
                
            Optional<Person> personOptional = personRepository.getPerson(firstName, lastName);
                
            if (personOptional.isPresent()) {
                Person currentPerson = personOptional.get();
            
                currentPerson.setAddress(updatedPerson.getAddress());
                currentPerson.setCity(updatedPerson.getCity());
                currentPerson.setZip(updatedPerson.getZip());
                currentPerson.setPhone(updatedPerson.getPhone());
                currentPerson.setEmail(updatedPerson.getEmail());
                
                personRepository.save(currentPerson); 
            
                return currentPerson;
                    } else {
                     
                return null;
                    }
                }
}






    