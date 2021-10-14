/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.repository;

import co.edu.usa.mt.ciclo3.boat.model.Score;
import co.edu.usa.mt.ciclo3.boat.repository.crud.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miguel
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
     public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    
    public Optional<Score> getBoat(int id){
        return scoreCrudRepository.findById(id);
    }
    
    public Score save(Score score){
        return scoreCrudRepository.save(score);
    }
}
