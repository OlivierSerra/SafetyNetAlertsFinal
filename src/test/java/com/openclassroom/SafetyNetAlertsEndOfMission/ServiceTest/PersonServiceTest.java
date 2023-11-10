package com.openclassroom.SafetyNetAlertsEndOfMission.ServiceTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.PersonService;

@SpringBootTest
public class PersonServiceTest {
    private PersonService personService;

    
    @Test    
    public void testUpdatePersonService() {
         
        String firstName = "John";
        String lastName = "Boyd";
        Person updatedPerson = new Person();
        updatedPerson.setAddress("1509 Culver St");
        updatedPerson.setCity("Culver");
        updatedPerson.setZip("97451");
        updatedPerson.setPhone("841-874-6512");
        updatedPerson.setEmail("jaboyd@email.com");

        Person result = personService.update(firstName, lastName, updatedPerson);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    
    }
    
    @Test    
    public void testSavePersonService() {
         
        String firstName = "John";
        String lastName = "Boyd";
        Person savedPerson = new Person();
        savedPerson.setAddress("1509 Culver St");
        savedPerson.setCity("Culver");
        savedPerson.setZip("97451");
        savedPerson.setPhone("841-874-6512");
        savedPerson.setEmail("jaboyd@email.com");

        Person result = personService.save(savedPerson);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    
    }
    
    @Test    
    public void testDeletePersonService() {
         
        String firstName = "John";
        String lastName = "Boyd";
        Person deletedPerson = new Person();
        deletedPerson.setAddress("1509 Culver St");
        deletedPerson.setCity("Culver");
        deletedPerson.setZip("97451");
        deletedPerson.setPhone("841-874-6512");
        deletedPerson.setEmail("jaboyd@email.com");

        Person result = personService.delete(firstName, lastName);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    }

    @Test    
    public void testAddPersonService() {
         
        String firstName = "John";
        String lastName = "Boyd";
        Person addedPerson = new Person();
        addedPerson.setAddress("1509 Culver St");
        addedPerson.setCity("Culver");
        addedPerson.setZip("97451");
        addedPerson.setPhone("841-874-6512");
        addedPerson.setEmail("jaboyd@email.com");

        Person result = personService.save(addedPerson);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    }

@Test    
    public void testGetPerson() {
         
        String firstName = "John";
        String lastName = "Boyd";
        Person getPerson = new Person();
        getPerson.setAddress("1509 Culver St");
        getPerson.setCity("Culver");
        getPerson.setZip("97451");
        getPerson.setPhone("841-874-6512");
        getPerson.setEmail("jaboyd@email.com");

        Person result = personService.save(getPerson);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    }
}







