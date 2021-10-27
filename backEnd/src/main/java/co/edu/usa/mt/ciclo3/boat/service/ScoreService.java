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
            Optional<Score> existent = scoreRepository.getById(admin.getIdScore());
            
            if (existent.isEmpty() ){
                return scoreRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Score> dbScore = scoreRepository.getById(id);
        boolean exito = false;
        if (!dbScore.isEmpty()){
            scoreRepository.delete(dbScore.get());
            exito = true;
        }
        return exito;
    }
    
    public Score update(Score reservation) {

        if (reservation.getIdScore()!= null) {
            Optional<Score> dbScore = scoreRepository.getById(reservation.getIdScore());

            if (!dbScore.isEmpty()) {
                if (reservation.getMessageText()!= null) {
                    dbScore.get().setMessageText(reservation.getMessageText());
                }
                if (reservation.getStars() != null && reservation.getStars() >= 1 && reservation.getStars() <= 5) {
                    dbScore.get().setStars(reservation.getStars());
                }
                return scoreRepository.save(dbScore.get());
            } else {
                return reservation;
            }
        }
        return reservation;
    }

    public Optional<Score> getById(int id) {
        return scoreRepository.getById(id);
    }
}
