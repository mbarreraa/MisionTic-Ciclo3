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
            Optional<Client> existent = clientRepository.getById(client.getIdClient());
            
            if (existent.isEmpty() ){
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Client> dbBoat = clientRepository.getById(id);
        boolean exito = false;
        if (!dbBoat.isEmpty()){
            clientRepository.delete(dbBoat.get());
            exito = true;
        }
        return exito;
    }
    
    public Client update(Client client) {

        if (client.getIdClient() != null) {
            Optional<Client> dbClient = clientRepository.getById(client.getIdClient());

            if (!dbClient.isEmpty()) {
                if (client.getName() != null) {
                    dbClient.get().setName(client.getName());
                }
                if (client.getAge()!= null) {
                    dbClient.get().setAge(client.getAge());
                }
                if (client.getEmail()!= null) {
                    dbClient.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!= null) {
                    dbClient.get().setPassword(client.getPassword());
                }
                return clientRepository.save(dbClient.get());
            } else {
                return client;
            }

        }
        return client;
    }

    public Optional<Client> getById(int id) {
        return clientRepository.getById(id);
    }
}
