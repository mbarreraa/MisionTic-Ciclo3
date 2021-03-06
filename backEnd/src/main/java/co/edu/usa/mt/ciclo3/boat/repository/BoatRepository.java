/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.repository;

import co.edu.usa.mt.ciclo3.boat.model.Boat;
import co.edu.usa.mt.ciclo3.boat.repository.crud.BoatCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miguel
 */
@Repository
public class BoatRepository {
    
    @Autowired
    private BoatCrudRepository boatCrudRepository;
    
    public List<Boat> getAll(){
        return (List<Boat>) boatCrudRepository.findAll();
    }
    
    public Optional<Boat> getById(int id){
        return boatCrudRepository.findById(id);
    }
    
    public Boat save(Boat boat){
        return boatCrudRepository.save(boat);
    }
    
    public void delete(Boat boat){
        boatCrudRepository.delete(boat);
    }
}
