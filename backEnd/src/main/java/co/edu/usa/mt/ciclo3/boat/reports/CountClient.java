/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.reports;

import co.edu.usa.mt.ciclo3.boat.model.Client;

/**
 *
 * @author miguel
 */
public class CountClient {
    
    private Double total;
    private Client client;

    public CountClient() {
    }

    public CountClient(Double total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
}
