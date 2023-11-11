package com.openclassroom.SafetyNetAlertsEndOfMission.repository;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.PersonService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(PersonRepository.class)

public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;
    @MockBean
    JsonReader jsonDataReader;
    @MockBean
    private List<Person> personList = new ArrayList<>();
    private Person Marie;
    private Person Olivier;
    private Person Bertrand;

@BeforeAll
    void setUp() throws Exception {
        Marie = new Person(
                "Marie",
                "Moore",
                "1509 Main Road",
                "Culver",
                "97451",
                "841-874-6512",
                "MARIEMOORE@email.com");
        Olivier = new Person(
                "Olivier",
                "Serra",
                "1550 Main Road",
                "Culver",
                "97451",
                "841-874-6542",
                "OlivierSerra@email.com");
        Bertrand = new Person(
                "Bertrand",
                "laClasse",
                "1521 Main Road",
                "Culver",
                "97451",
                "841-874-6559",
                "BeertrandLaClasse@email.com");

        List<Person> personList = Arrays.asList(Marie, Olivier, Bertrand);
        PersonRepository personRepository;
    }

    @Test
    public void testSave() {
        // Créez une instance de votre service
        PersonRepository personRepository;

        // Créez une personne pour sauvegarder
        Person personToSave = new Person(
                "Marie",
                "Moore",
                "1509 Main Road",
                "Culver",
                "97451",
                "841-874-6512",
                "MARIEMOORE@email.com");

        // Appelez la méthode save
        Person savedPerson = personRepository.save(personToSave);

        // Vérifiez si la personne sauvegardée est égale à celle que vous avez créée
        assertNotNull(savedPerson);
        assertEquals("Marie", savedPerson.getFirstName());
        assertEquals("Moore", savedPerson.getLastName());
    }
    

@Test
    public void testUpdate() {
        // Créez une instance de votre service
        PersonRepository personRepository; 

        // Créez une personne à sauvegarder
        Person personToSave = new Person("Marie", "Moore",
                "1509 Main Road",
                "Culver",
                "97451",
                "841-874-6512",
                "MARIEMOORE@email.com");

        // Sauvegardez la personne
        Person savedPerson = personRepository.save(personToSave);

        // Créez une nouvelle instance de personne avec des informations mises à jour
        Person updatedPerson = new Person(
            "Marie",
            "Moore",
            "1509 Main Road",
            "Culver",
            "97451",
            "841-874-6513",
            "MARIEMOORE@email.com");
        updatedPerson.setAddress("1565 Main Road"); 
               
        // Appelez la méthode update
        Person result = personRepository.updatePerson("Marie", "Moore", updatedPerson);

        // Vérifiez si la personne mise à jour est égale à celle que vous avez créée
        assertNotNull(result);
        assertEquals("Marie", result.getFirstName());
        assertEquals("Moore", result.getLastName());
        
        assertSame(savedPerson, result);
    }

    @Test
    public void testFindByNameFirstAndLastName() {
        // Créez une instance de votre service
        PersonRepository personRepository;

        // Créez une personne fictive
        Person person = new Person(
                "Marie",
                "Moore",
                "1509 Main Road",
                "Culver",
                "97451",
                "841-874-6512",
                "MARIEMOORE@email.com");

        // Ajoutez la personne fictive à la liste
        personRepository.save(person);

        // Utilisez Mockito pour simuler la liste de personnes dans votre service
        PersonRepository spyPersonRepository = spy(personRepository);

        // Définissez le comportement espéré lors de l'appel de FindByNameFirstAndLastName
        when(spyPersonRepository.FindByNameFirstAndLastName("Marie", "Moore")).thenReturn(Optional.of(person));

        // Appelez la méthode à tester
        Optional<Person> result = spyPersonRepository.FindByNameFirstAndLastName("Marie", "Moore");

        // Vérifiez si la personne a été trouvée
        assertTrue(result.isPresent());
        
        // Vérifiez si la personne trouvée est la même que celle que vous avez ajoutée
        assertSame(person, result.get());

        // Vérifiez le cas où la personne n'est pas trouvée
        Optional<Person> resultNotFound = spyPersonRepository.FindByNameFirstAndLastName("Marie", "Moore");
        assertFalse(resultNotFound.isPresent());
        }
    }
