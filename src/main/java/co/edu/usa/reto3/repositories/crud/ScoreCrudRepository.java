package co.edu.usa.reto3.repositories.crud;

import co.edu.usa.reto3.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
    
}
