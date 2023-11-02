package com.openclassroom.SafetyNetAlertsEndOfMission.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassroom.SafetyNetAlertsEndOfMission.services.PersonService;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;


@RestController
@ComponentScan(basePackages = "com.openclassroom.SafetyNetAlertsEndOfMission")
public class PersonController {

    @Autowired
    private PersonService personService;


 /********************** Endpoint / Person   *********************** */

 /* 
* This method is used to find the list with all the people  
*/
@GetMapping("/person") 
    public List<Person>person() {
    return personService.findAll();
        }
 
/*  
 * This méthod is used to add one person in the list
*/
    @PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
	return personService.save(person);
	}

    @DeleteMapping("/person")
    public Person deletePerson(@RequestBody Person person) {   
    return personService.delete(person);
        }
/*This method is used to update person data
 */         
    @PutMapping("/person/{firstName}/{lastName}")
    public Person updatePerson(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @RequestBody Person updatedPerson) {
        return personService.updatePerson(firstName, lastName, updatedPerson);        
    }
 

        
}    
    






    