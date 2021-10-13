/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.controller;

import co.edu.usa.mt.ciclo3.boat.model.Reservation;
import co.edu.usa.mt.ciclo3.boat.service.ReservationService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author miguel
 */
@RestController
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> list() {
        return reservationService.getAll();
    }
    /*
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    */
}
