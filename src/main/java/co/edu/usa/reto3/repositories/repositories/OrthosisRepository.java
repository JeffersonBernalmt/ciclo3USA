package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.Orthosis;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.OrthosisCrudRepository;

@Repository
public class OrthosisRepository {
    @Autowired
    private OrthosisCrudRepository repoOrthosis;
    
    public List<Orthosis> getAll(){
        return (List<Orthosis>)repoOrthosis.findAll();
    }
    
    public List<Orthosis> getByIdCategory(int idCategory) {
        return (List<Orthosis>) repoOrthosis.findByIdCategoryOrderByNameAsc(idCategory);
    }
    
    public Optional<Orthosis> getById(int id) {
        return repoOrthosis.findById(id);
    }
    
    public Orthosis save(Orthosis orthosis){
        return repoOrthosis.save(orthosis);
    }
    
    public void delete(Orthosis orthosis){
        repoOrthosis.delete(orthosis);
    }
}
