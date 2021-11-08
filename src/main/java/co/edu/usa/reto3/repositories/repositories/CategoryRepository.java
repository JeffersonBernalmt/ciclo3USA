package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository repoCategory;
    
    public List<Category> getAll(){
        return (List<Category>)repoCategory.findAll();
    }
    
    public Optional<Category> getById(int id) {
        return repoCategory.findById(id);
    }
    
    public Category save(Category categoria){
        return repoCategory.save(categoria);
    }
    
    public void delete(Category categoria){
        repoCategory.delete(categoria);
    }
}
