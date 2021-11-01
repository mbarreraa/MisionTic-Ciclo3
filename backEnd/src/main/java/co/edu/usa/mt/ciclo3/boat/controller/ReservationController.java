/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.controller;

import co.edu.usa.mt.ciclo3.boat.model.Reservation;
import co.edu.usa.mt.ciclo3.boat.reports.CountClient;
import co.edu.usa.mt.ciclo3.boat.reports.ReservationStatus;
import co.edu.usa.mt.ciclo3.boat.service.ReservationService;
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
@RequestMapping("/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> list() {
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable int id) {
        return reservationService.getById(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable int id) {
        return reservationService.delete(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED) 
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }
    
    @GetMapping("/report-status")
    public ReservationStatus getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationPeriod(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return  reservationService.getReservationPeriod(dateOne, dateTwo);
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getTopClients(){
        return reservationService.getTopClients();
    }
}
