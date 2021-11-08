package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Category;
import co.edu.usa.reto3.repositories.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
    return categoryRepository.getAll();
    }
    
    public Category getById(int id){
    Optional<Category> category = categoryRepository.getById(id);
    return category.orElse(new Category());
    }
    
    public Category save(Category category){
        if ((category.getName().length()>45) || (category.getDescription().length()>250)){
            return category;
       }else{
        return categoryRepository.save(category);
        }
    }
    
    public boolean delete(int id) {
        //System.out.println("deleting Category with id: " + id);
        boolean d = categoryRepository.getById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> categoryConsulted = categoryRepository.getById(category.getId());
            if (categoryConsulted.isPresent()) {
                if (category.getName() != null) {
                    categoryConsulted.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    categoryConsulted.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(categoryConsulted.get());
            }
        }
        return category;
    }
}
