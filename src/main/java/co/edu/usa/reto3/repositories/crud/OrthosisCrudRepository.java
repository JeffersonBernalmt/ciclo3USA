package co.edu.usa.reto3.repositories.crud;

import co.edu.usa.reto3.model.Orthosis;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrthosisCrudRepository extends CrudRepository<Orthosis, Integer>{
    
    @Query(value="select * from ortopedics where idCategory = ? order by name ASC", nativeQuery = true)
    public List<Orthosis> findByIdCategoryOrderByNameAsc(int idCategory);
    
}

