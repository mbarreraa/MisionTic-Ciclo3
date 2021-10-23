/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.mt.ciclo3.boat.service;

import co.edu.usa.mt.ciclo3.boat.model.Category;
import co.edu.usa.mt.ciclo3.boat.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguel
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Category save(Category category) {

        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> existent = categoryRepository.getCategory(category.getId());

            if (existent.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    
    public boolean delete(int id){
        Optional<Category> dbCategory = categoryRepository.getCategory(id);
        boolean exito = false;
        if (!dbCategory.isEmpty()){
            categoryRepository.delete(dbCategory.get());
            exito = true;
        }
        return exito;
    }

    public Category update(Category category) {

        if (category.getId() != null) {
            Optional<Category> dbCategory = categoryRepository.getCategory(category.getId());

            if (!dbCategory.isEmpty()) {
                if (category.getName() != null) {
                    dbCategory.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    dbCategory.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(dbCategory.get());
            } else {
                return category;
            }

        }
        return category;
    }

    public Optional<Category> getById(int id) {
        return categoryRepository.getCategory(id);
    }
}
