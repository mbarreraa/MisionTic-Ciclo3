/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.repository;

import co.edu.usa.mt.ciclo3.boat.model.Client;
import co.edu.usa.mt.ciclo3.boat.model.Reservation;
import co.edu.usa.mt.ciclo3.boat.reports.CountClient;
import co.edu.usa.mt.ciclo3.boat.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author miguel
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getById(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    public List<CountClient> getTopClients(){
        List<CountClient> clientList = new ArrayList<>();
        List<Object[]> reports = reservationCrudRepository.countTotalReservationByClient();
        
        for (Object[] report : reports) {
            clientList.add(new CountClient(Long.parseLong(report[1].toString()), (Client)report[0]));
        }
        
        return clientList;
    }
}
