package com.openclassroom.SafetyNetAlertsEndOfMission;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;
import com.openclassroom.SafetyNetAlertsEndOfMission.repository.PersonRepository;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.PersonService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PersonServiceTest {
    private PersonService personService = new PersonService();

    
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

        Person result = personService.updatePerson(firstName, lastName, updatedPerson);

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

        Person result = personService.delete(deletedPerson);

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


    /*

    @Test    
    public void testUpdatePerson() {

        private PersonService personService;
        private PersonRepository personRepository;

        @Before 
        public void setUp() {
            // Créez un mock pour PersonRepository
            PersonRepository personRepository = mock(PersonRepository.class);
    
            // Créez une instance de PersonService en injectant le mock de PersonRepository
            PersonService personService = new PersonService(personRepository);
        }

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

        // Configuration du comportement du mock de PersonRepository
        when(personRepository.getPerson("John", "Boyd")).thenReturn(new Person()); // Mock la méthode utilisée pour rechercher une personne
        when(personRepository.save(any(Person.class))).thenReturn(updatedPerson); // Mock la méthode utilisée pour enregistrer la personne mise à jour

        // Appel de la méthode que vous voulez tester
        Person result = personService.updatePerson(firstName, lastName, updatedPerson);

        // Assertions
        assertNotNull(result);
        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
    }
 */
/*
        when(personService.getPerson("John", "Boyd")).thenReturn(new Person()); 
        when(personService.save(any(Person.class))).thenReturn(updatedPerson); 

        PersonService personService = new PersonService(MockPersonService);

        @Test    
        public void testUpdatePersonService() {
    // ... Le reste de votre code de test

        String firstName = "John";
        String lastName = "Boyd";
        Person updatedPerson = new Person();
        updatedPerson.setAddress("1509 Culver St");
        updatedPerson.setCity("Culver");
        updatedPerson.setZip("97451");
        updatedPerson.setPhone("841-874-6512");
        updatedPerson.setEmail("jaboyd@email.com");

        Person result = personService.updatePerson(firstName, lastName, updatedPerson);

        assertNotNull(result);

        assertEquals("1509 Culver St", result.getAddress());
        assertEquals("Culver", result.getCity());
        assertEquals("97451", result.getZip());
        assertEquals("841-874-6512", result.getPhone());
        assertEquals("jaboyd@email.com", result.getEmail());
 

    // Vous pouvez maintenant tester la méthode updatePerson en utilisant les mocks configurés.
*/
}







