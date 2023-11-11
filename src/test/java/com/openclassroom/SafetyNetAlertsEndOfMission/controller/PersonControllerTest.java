package com.mariemoore.safetynet.controller;

import com.mariemoore.safetynet.jsonUtils;
import com.mariemoore.safetynet.model.Person;
import com.mariemoore.safetynet.service.PersonService;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {
    @Autowired
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

    /************************** Test Controller ************************************/


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



}
