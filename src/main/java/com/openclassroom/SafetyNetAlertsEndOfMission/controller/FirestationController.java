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

import com.openclassroom.SafetyNetAlertsEndOfMission.services.FirestationService;
import com.openclassroom.SafetyNetAlertsEndOfMission.model.Firestation;

@RestController
@ComponentScan(basePackages = "com.openclassroom.SafetyNetAlertsEndOfMission")
public class FirestationController{

    @Autowired
    private FirestationService firestationService;
    
 /********************** Endpoint / Person   *********************** */

 /* 
* This method is used to find the list with all the people  
*/
    @GetMapping("/firestation") 
    public List<Firestation>firestation() {
    return firestationService.findAll();
        }

/*  
 * This méthod is used to add one person in the list
*/
    @PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
	return firestationService.saveFirestation(firestation);
	}
/*Est-ce qu'on conserve ce mode de fonctioonnement?
 * selon l'énoncé, on doit supp un mapping d'une caserne ou d'une adresse 
 */
    @DeleteMapping("/firestation")
    public Firestation deletePerson(@RequestBody Firestation firestation) {   
    return firestationService.deleteFirestation(firestation);
        }

  /*
  *This method is used to update person data. 
  *Problem with the put mapping. When we use putmapping with a new firestation, we have two created firestation. 
  */        
    @PutMapping("/firestation/{address}")
    public Firestation updateFirestation(
            @PathVariable("address") String address,
            @RequestBody Firestation updatedFirestation) {
        return firestationService.updateFirestation(address, updatedFirestation.getStation());        
    }
 

}    
    






    