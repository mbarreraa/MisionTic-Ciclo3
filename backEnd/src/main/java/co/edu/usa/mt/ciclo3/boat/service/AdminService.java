/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Admin;
import co.edu.usa.mt.ciclo3.boat.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Admin save(Admin admin){
        
        if (admin.getIdAdmin()== null){
            return adminRepository.save(admin);
        } else {
            Optional<Admin> existent = adminRepository.getBoat(admin.getIdAdmin());
            
            if (existent.isEmpty() ){
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
}
