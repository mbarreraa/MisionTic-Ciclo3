/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Client;
import co.edu.usa.mt.ciclo3.boat.model.Message;
import co.edu.usa.mt.ciclo3.boat.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Message save(Message message){
        
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        } else {
            Optional<Message> existent = messageRepository.getMessage(message.getIdMessage());
            
            if (existent.isEmpty() ){
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
}
