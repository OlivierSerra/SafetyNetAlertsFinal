package com.openclassroom.SafetyNetAlertsEndOfMission.services;


import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;


@Component
@Service
public class FirestationService {

    private JsonReader jsonDataReader;
    public List<Firestation> firestations;

    public FirestationService(JsonReader jsonDataReader) throws Exception {
        this.jsonDataReader = jsonDataReader;
        this.firestations = this.jsonDataReader.getFirestationsData();
    }

        public FirestationService() {
    }

        /********************* endpoint/firestation   ********************/

/* 
 * return all firestation after interrogation of firestation list 
*/
    public List<Firestation> findAll() {
        return this.firestations;
    }

 /*
  * add firestation in the list
  */
    public Firestation saveFirestation(Firestation firestation) {
        firestations.add(firestation);
        return firestation;
        }

/*
 * used to delete a firestation
*/ 
    public Firestation deleteFirestation(Firestation firestation) {
        firestations.remove(firestation);
        return firestation;
        }

/*
 * return firestation if criterias match  
*/
     public Firestation updateFirestation( String address, int station) {
        Optional<Firestation> firestationOptional = getFirestation(address);

        if (firestationOptional.isPresent()) {
            Firestation updatedFirestation = firestationOptional.get();
            updatedFirestation.setStation(station);
            return saveFirestation(updatedFirestation);
        }
        return null;
    }

    public Optional<Firestation> getFirestation(String address ) {  
        for (Firestation firestation : firestations) {
        if (firestation.getAddress().equals(address)) {
            return Optional.of(firestation); 
        }
    }
    return Optional.empty(); 
}  
    
}







