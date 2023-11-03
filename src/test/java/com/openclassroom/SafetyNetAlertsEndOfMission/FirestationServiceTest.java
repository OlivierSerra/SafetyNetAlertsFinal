package com.openclassroom.SafetyNetAlertsEndOfMission;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;
import com.openclassroom.SafetyNetAlertsEndOfMission.services.FirestationService;

@SpringBootTest
public class FirestationServiceTest {
    private FirestationService firestationService = new FirestationService();


    @Test    
    public void testUpdateFirestation()  {
            
            String address = "1509 Culver St";
            int station = 3;
            Firestation updatedFirestation = new Firestation();
            updatedFirestation.setAddress(address);
            updatedFirestation.setStation(station);

            Firestation result = firestationService.updateFirestation(address, station);
    
            assertNotNull(result);
    
            assertEquals("1509 Culver St", result.getAddress());
            assertEquals("3", result.getStation());
            }

        @Test    
        public void testDeleteFirestation() {
            
            String address = "1509 Culver St";
            int station = 3;
            Firestation deletedFirestation = new Firestation();
            deletedFirestation.setAddress(address);
            deletedFirestation.setStation(station);
    
            Firestation result = firestationService.deleteFirestation(deletedFirestation);
    
            assertNotNull(result);
    
            assertEquals("1509 Culver St", result.getAddress());
            assertEquals("3", result.getStation());
        }

        @Test    
        public void testSaveFirestation() {
            
            String address = "1509 Culver St";
            int station = 3;
            Firestation savedFirestation = new Firestation();
            savedFirestation.setAddress(address);
            savedFirestation.setStation(station);
    
            Firestation result = firestationService.saveFirestation(savedFirestation);
    
            assertNotNull(result);
    
            assertEquals("1509 Culver St", result.getAddress());
            assertEquals("3", result.getStation());
        }

        @Test    
        public void testAddFirestation() {
            
            String address = "1509 Culver St";
            int station = 3;
            Firestation addedFirestation = new Firestation();
            addedFirestation.setAddress(address);
            addedFirestation.setStation(station);
    
            Firestation result = firestationService.saveFirestation(addedFirestation);
    
            assertNotNull(result);
    
            assertEquals("1509 Culver St", result.getAddress());
            assertEquals("3", result.getStation());
        }

        @Test    
        public void testGetFirestation() {
            
            String address = "1509 Culver St";
            int station = 3;
            Firestation getFirestation = new Firestation();
            getFirestation.setAddress(address);
            getFirestation.setStation(station);
    
            Firestation result = firestationService.saveFirestation(getFirestation);
    
            assertNotNull(result);
    
            assertEquals("1509 Culver St", result.getAddress());
            assertEquals("3", result.getStation());
        }
}

