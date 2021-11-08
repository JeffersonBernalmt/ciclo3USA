package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Client;
import co.edu.usa.reto3.repositories.repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
    return clientRepository.getAll();
    }

    public Client getById(int id){
    Optional<Client> cliente = clientRepository.getById(id);
    return cliente.orElse(new Client());
    }
    
    public Client save(Client client){
        if ((client.getEmail().length()>45) || (client.getPassword().length()>450)||(client.getName().length()>250)){
        return client;
                } else {
    return clientRepository.save(client);
                }
    }
    
    public boolean delete(int id) {
        Boolean d = clientRepository.getById(id).map(producto -> {
            clientRepository.delete(producto);
            return true;
        }).orElse(false);
        return d;
    }  

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientConsulted = clientRepository.getById(client.getIdClient());
            if (clientConsulted.isPresent()) {
                if (client.getEmail() != null) {
                    clientConsulted.get().setEmail(client.getEmail());
                }
                 if (client.getPassword() != null) {
                    clientConsulted.get().setPassword(client.getPassword());
                }
                  if (client.getName() != null) {
                    clientConsulted.get().setName(client.getName());
                }
                   if (client.getAge() != null) {
                    clientConsulted.get().setAge(client.getAge());
                }
                return clientRepository.save(clientConsulted.get());
            }
        }
        return client;
    }
}
