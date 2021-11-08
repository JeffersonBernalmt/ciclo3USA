package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.MessageCrudRepository;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository repoMessage;
    
    public List<Message> getAll(){
        return (List<Message>)repoMessage.findAll();
    }
    
    public Optional<Message> getById(int id) {
        return repoMessage.findById(id);
    }
    
    public Message save(Message message){
        return repoMessage.save(message);
    }
    
    public void delete(Message message){
        repoMessage.delete(message);
    }
}
