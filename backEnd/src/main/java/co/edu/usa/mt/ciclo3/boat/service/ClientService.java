/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Client;
import co.edu.usa.mt.ciclo3.boat.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Client save(Client client){
        
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        } else {
            Optional<Client> existent = clientRepository.getClient(client.getIdClient());
            
            if (existent.isEmpty() ){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
}
