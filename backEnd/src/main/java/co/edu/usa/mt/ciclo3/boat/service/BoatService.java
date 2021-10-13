/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Boat;
import co.edu.usa.mt.ciclo3.boat.repository.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class BoatService {
        
    @Autowired
    private BoatRepository boatRepository;
    
    public List<Boat> getAll(){
        return boatRepository.getAll();
    }
    
    public Boat save(Boat boat){
        
        if (boat.getId() == null){
            return boatRepository.save(boat);
        } else {
            Optional<Boat> existent = boatRepository.getBoat(boat.getId());
            
            if (existent.isEmpty() ){
                return boatRepository.save(boat);
            } else {
                return boat;
            }
        }
    }
}
