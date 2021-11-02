/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.reports;

/**
 *
 * @author miguel
 */
public class ReservationStatus {
    
    private Integer completed;
    private Integer cancelled;

    public ReservationStatus() {
    }

    public ReservationStatus(Integer completed, Integer canceled) {
        this.completed = completed;
        this.cancelled = canceled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

}
