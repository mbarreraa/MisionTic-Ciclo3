/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Reservation;
import co.edu.usa.mt.ciclo3.boat.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Reservation save(Reservation reservation){
        
        if (reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> existent = reservationRepository.getById(reservation.getIdReservation());
            
            if (existent.isEmpty() ){
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Reservation> dbReservation = reservationRepository.getById(id);
        boolean exito = false;
        if (!dbReservation.isEmpty()){
            reservationRepository.delete(dbReservation.get());
            exito = true;
        }
        return exito;
    }
    
    public Reservation update(Reservation reservation) {

        if (reservation.getIdReservation() != null) {
            Optional<Reservation> dbReservation = reservationRepository.getById(reservation.getIdReservation());

            if (!dbReservation.isEmpty()) {
                if (reservation.getDevolutionDate()!= null) {
                    dbReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStartDate()!= null) {
                    dbReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus()!= null) {
                    dbReservation.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(dbReservation.get());
            } else {
                return reservation;
            }
        }
        return reservation;
    }

    public Optional<Reservation> getById(int id) {
        return reservationRepository.getById(id);
    }
}
