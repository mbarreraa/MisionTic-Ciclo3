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
    private Integer canceled;

    public ReservationStatus() {
    }

    public ReservationStatus(Integer completed, Integer canceled) {
        this.completed = completed;
        this.canceled = canceled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCanceled() {
        return canceled;
    }

    public void setCanceled(Integer canceled) {
        this.canceled = canceled;
    }
    
}
