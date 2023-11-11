package com.openclassroom.SafetyNetAlertsEndOfMission.controller;

import com.openclassroom.SafetyNetAlertsEndOfMission.jsonUtils;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Person;
import com.openclassroom.SafetyNetAlertsEndOfMission.repository.PersonRepository;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.PersonService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
        
@WebMvcTest(PersonControllerTest.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonControllerTest personControllerTest;
    private MockMvc mockMvc;

    @Test
    public void testPersons() throws Exception {
        // Données de test
        Person Marie = new Person(
                "Marie",
                "Moore",
                "1509 Main Road",
                "Culver",
                "97451",
                "841-874-6512",
                "MARIEMOORE@email.com");
        Person Olivier  = new Person(
                "Olivier",
                "Serra",
                "1550 Main Road",
                "Culver",
                "97451",
                "841-874-6542",
                "OlivierSerra@email.com");
        Person Bertrand = new Person(
                    "Bertrand",
                    "laClasse",
                    "1521 Main Road",
                    "Culver",
                    "97451",
                    "841-874-6559",
                    "BeertrandLaClasse@email.com");        
        List<Person> personList = Arrays.asList(Marie, Olivier, Bertrand);

        // Définir le comportement du service mocké
        when(personService.findAll()).thenReturn(personList);

    // Effectuer la requête et vérifier le statut de la réponse
        mockMvc.perform(get("/person"))
                .andExpect(status().isOk())
                // Vérifier la structure de la réponse JSON, ajustez-la en fonction de votre implémentation
                .andExpect(jsonPath("$[0].name").value("Marie"))
                .andExpect(jsonPath("$[1].name").value("Olivier"));
                .andExpect(jsonPath("$[2].name").value("Bertrand"));

        // Vérifier que la méthode du service a été appelée une fois
        verify(personService, times(1)).findAll();
    }


/************************************* mock et test unitaire    ********************************/
    /*
        @Mock
        private PersonService personService;
        
        @InjectMocks
        private YourController yourController;

        private MockMvc mvc;

        @MockBean
        PersonService personService;

        private List<Person> personList;
        private Person john;
        private Person jacob;
        private Person tenley;

        @BeforeAll
        void setup() {
            john = new Person(
                    "John",
                    "Boyd",
                    "1509 Culver St",
                    "Culver",
                    "97451",
                    "841-874-6512",
                    "jaboyd@email.com");
            jacob = new Person(
                    "Jacob",
                    "Boyd",
                    "1509 Culver St",
                    "Culver",
                    "97451",
                    "841-874-6513",
                    "drk@email.com");

            tenley = new Person(
                    "Tenley",
                    "Boyd",
                    "1509 Culver St",
                    "Culver",
                    "97451",
                    "841-874-6512",
                    "tenz@email.com");

            personList = Arrays.asList(john, jacob, tenley);
        }

        @Test
        public void getAllPersonsShouldReturnListOfPersons() throws Exception{
            when(personService.getPersons()).thenReturn(personList);
            mvc.perform(get("/person/all"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(3)))
                    .andExpect(jsonPath("$[0].firstName", is("John")))
                    .andExpect(jsonPath("$[1].firstName", is("Jacob")))
                    .andExpect(jsonPath("$[2].firstName", is("Tenley")));
        }

        @Test
        public void addPersonShouldReturnPerson() throws Exception {
            when(personService.addPerson(john)).thenReturn(john);
            mvc.perform(post("/person")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonUtils.asJsonString(john)))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        public void addPersonWhoAlreadyExistsShouldNotReturnPerson() throws Exception {
            when(personService.addPerson(john)).thenReturn(null);
            mvc.perform(post("/person")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonUtils.asJsonString(john)))
                    .andDo(print())
                    .andExpect(status().isNoContent());
        }

        @Test
        public void updatePersonShouldReturnPerson() throws Exception {
            when(personService.updatePerson(john)).thenReturn(john);
            mvc.perform(put("/person")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(jsonUtils.asJsonString(john)))
                    .andDo(print())
                    .andExpect(result -> assertEquals(jsonUtils.asJsonString(john), result.getResponse().getContentAsString()))
                    .andExpect(status().isOk());
        }

        @Test
        public void updatePersonWhoDoesNotExistShouldNotReturnPerson() throws Exception {
        when(personService.updatePerson(john)).thenReturn(null);
        mvc.perform(put("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(john)))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deletePersonShouldReturnNoContent() throws Exception {
        when(personService.deletePerson(john.getFirstName(), john.getLastName())).thenReturn(john);
        mvc.perform(delete("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(john)))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deletePersonWhoDoesNotExistsShouldReturnNoContent() throws Exception {
        when(personService.deletePerson(john.getFirstName(), john.getLastName())).thenReturn(null);
        mvc.perform(delete("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonUtils.asJsonString(john)))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
 */
    /*
    ************************* Test Controller ***********************************
    


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
*/
/**********************    Mockito test ********************************/



}



}
