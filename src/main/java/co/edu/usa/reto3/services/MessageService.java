package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Message;
import co.edu.usa.reto3.repositories.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
    return messageRepository.getAll();
    }
    
    public Message getById(int id){
    Optional<Message> mensaje = messageRepository.getById(id);
    return mensaje.orElse(new Message());
    }
    
    public Message save(Message mensaje){
        if ((mensaje.getMessageText().length()>250)){
            return mensaje;
        }else{
      return messageRepository.save(mensaje);
        }
    }
    
    public boolean delete(int id) {
        System.out.println("deleting Categoria with id: " + id);
        boolean del = messageRepository.getById(id).map(categoria -> {
            messageRepository.delete(categoria);
            return true;
        }).orElse(false);
        return del;
    }
    
    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageConsulted = messageRepository.getById(message.getIdMessage());
            if (messageConsulted.isPresent()) {
                if (message.getMessageText() != null) {
                    messageConsulted.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(messageConsulted.get());
            }
        }
        return message;
    }
    
}
