package com.openclassroom.SafetyNetAlertsEndOfMission.repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;
import java.util.List;
import java.util.Optional;

@Component
@Repository
public class FirestationRepository {

    public List<Firestation> firestations;
    private JsonReader jsonDataReader; 

    public FirestationRepository(JsonReader jsonDataReader) throws Exception {
        this.jsonDataReader = jsonDataReader;
        this.firestations = this.jsonDataReader.getFirestationsData();
    }

    public List<Firestation> findAll() {
        return this.firestations;
    }

    /* find one firestation
    * 
    */    
    //fait fonctionner la fonction delete de type firestation
    public Firestation firestation(String address, Integer station) {  
        for (Firestation firestation : firestations) {
        if (firestation.getAddress().equals(address) && firestation.getStation().equals(station)) {
            return firestation; 
        }
    }
    return null; 
    }

    //fait fonctionner la fonction update de type optionnal
    public Optional<Firestation> FindByAddressAndStationNumber(String address, Integer station) {  
        for (Firestation firestation : firestations) {
        if (firestation.getAddress().equals(address) && firestation.getStation().equals(station)) {
            return Optional.of(firestation); 
        }
    }
    return Optional.empty(); 
    }

    /*
    *Save
    */
    public Firestation saveFirestation(Firestation firestation) {
        for (Firestation existingFirestation : firestations) {
            if (existingFirestation.getAddress().equals(firestation.getAddress()) && existingFirestation.getStation().equals(firestation.getStation())) {
                return existingFirestation;
            }
        }
        firestations.add(firestation); 
        return firestation;
    }

       
    /*
    * update
    */
    public Firestation updateFirestation(String address, Integer station, Firestation firestationToUpdate) {
        Optional<Firestation> firestationOptional = FindByAddressAndStationNumber(address, station);

        if (firestationOptional.isPresent()) {
            Firestation updatedFirestation = firestationOptional.get();

            updatedFirestation.setStation(firestationToUpdate.getStation());
            
            return saveFirestation(updatedFirestation);
        }
        return null;
    }
/*************************************** Delete ******************************** */
 
    public Firestation deleteFirestation(String address, Integer station) {
        Firestation deletedfirestation = null;
        Firestation firestationToDelete = firestation(address, station);
        for (Firestation p : this.firestations) {
        if (p.getAddress().equals(address) && p.getStation().equals(station)) {
            firestations.remove(p);
            return deletedfirestation = firestationToDelete; 
        }
    }
    return deletedfirestation;
    }

}
