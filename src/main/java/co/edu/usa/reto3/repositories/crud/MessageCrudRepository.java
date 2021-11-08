package co.edu.usa.reto3.repositories.crud;

import co.edu.usa.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
