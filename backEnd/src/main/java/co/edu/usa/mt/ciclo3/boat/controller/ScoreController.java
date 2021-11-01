/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.controller;

import co.edu.usa.mt.ciclo3.boat.model.Score;
import co.edu.usa.mt.ciclo3.boat.service.ScoreService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author miguel
 */
@RestController
@RequestMapping("/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> list() {
        return scoreService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Score> getById(@PathVariable int id) {
        return scoreService.getById(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score) {
        return scoreService.save(score);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return scoreService.delete(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) 
    public Score update(@RequestBody Score score) {
        return scoreService.update(score);
    }
}
