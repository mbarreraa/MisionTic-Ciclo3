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
    
    public Optional<Admin> getById(int id){
        return adminRepository.get(id);
    }
    
    public Admin save(Admin admin){
        
        if (admin.getIdAdmin()== null){
            return adminRepository.save(admin);
        } else {
            Optional<Admin> existent = adminRepository.get(admin.getIdAdmin());
            
            if (existent.isEmpty() ){
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Admin> dbAdmin = adminRepository.get(id);
        boolean exito = false;
        if (!dbAdmin.isEmpty()){
            adminRepository.delete(dbAdmin.get());
            exito = true;
        }
        return exito;
    }
    
    public Admin update(Admin admin) {

        if (admin.getIdAdmin() != null) {
            Optional<Admin> dbAdmin = adminRepository.get(admin.getIdAdmin());

            if (!dbAdmin.isEmpty()) {
                if (admin.getName() != null) {
                    dbAdmin.get().setName(admin.getName());
                }
                if (admin.getEmail()!= null) {
                    dbAdmin.get().setEmail(admin.getEmail());
                }
                if (admin.getPassword()!= null) {
                    dbAdmin.get().setPassword(admin.getPassword());
                }
                return adminRepository.save(dbAdmin.get());
            } else {
                return admin;
            }

        }
        return admin;
    }
}
