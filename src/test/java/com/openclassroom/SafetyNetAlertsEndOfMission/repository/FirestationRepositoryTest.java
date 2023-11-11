package com.openclassroom.SafetyNetAlertsEndOfMission.repository;


import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;
//import com.openclassroom.SafetyNetAlertsEndOfMission.JsonReader;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(FirestationRepository.class)
public class FirestationRepositoryTest {
    @Autowired
    FirestationRepository firestationRepository;

    @MockBean
    JsonReader dataReader;

    private List<Firestation> firestationList;

    private Firestation firstFirestation;
    private Firestation secondFirestation;
    private Firestation thirdFirestation;
    @BeforeAll
    void setUp() {
        firstFirestation = new Firestation(
                3,
                "1509 Culver St");
        
        firestationList = Arrays.asList(firstFirestation);
        firestationRepository = new FirestationRepository(JsonReader dataReader);
    }

    @Test
    public void findAllSuccessTest() {
        firestationRepository.firestations = firestationList;
        List<Firestation> result = firestationRepository.findAll();
        Assertions.assertEquals(3, result.size());
    }

    @Test
    public void saveFirestationShouldReturnOk() {
        Firestation firestationToSave = new Firestation(
                30,
                "Main St");

        firestationRepository.firestations = new ArrayList<>(dataReader.getFirestationsData());
        firestationRepository.saveFirestation(firestationToSave.getStation(), firestationToSave.getAddress());
        Integer result = firestationRepository.FindByAddressAndStationNumber(firestationToSave.getAddress());
        Assertions.assertEquals(30, result);
        assertNotNull(result);
    }

    @Test
    public void updateFirestationShouldReturnOk() {
        Firestation toSave = new Firestation(
                30,
                "Main St");
        firestationRepository.firestations = new ArrayList<>(dataGetter.getFirestationsData());
        firestationRepository.saveFirestation(toSave.getStation(), toSave.getAddress());
        Integer result = firestationRepository.FindByAddressAndStationNumber(toSave.getAddress());
        Assertions.assertEquals(30, result);
        firestationRepository.updateFirestation(new Firestation(
                33,
                "Main St"));
        Integer updated = firestationRepository.findStationNumberByAddress(toSave.getAddress());
        Assertions.assertEquals(33, updated);
    }

    @Test
    public void deleteFirestationShouldReturnOk() {
        firestationRepository.saveFirestation(3,"Main St");
        Integer result = firestationRepository.findStationNumberByAddress("Main St");
        Assertions.assertEquals(3, result);
        firestationRepository.deleteFirestation(new Firestation(3,"Main St"));
        Integer deleted = firestationRepository.findStationNumberByAddress("Main St");
        Assertions.assertEquals(null, deleted);
    }

}
