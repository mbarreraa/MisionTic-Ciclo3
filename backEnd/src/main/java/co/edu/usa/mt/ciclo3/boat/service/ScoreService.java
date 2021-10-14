/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Score;
import co.edu.usa.mt.ciclo3.boat.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Score save(Score admin){
        
        if (admin.getIdScore()== null){
            return scoreRepository.save(admin);
        } else {
            Optional<Score> existent = scoreRepository.getBoat(admin.getIdScore());
            
            if (existent.isEmpty() ){
                return scoreRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
    
}
