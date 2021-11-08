package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.ClientCrudRepository;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository repoClient;
    
    public List<Client> getAll(){
        return (List<Client>)repoClient.findAll();
    }
    
    public Optional<Client> getById(int id) {
        return repoClient.findById(id);
    }
    
    public Client save(Client client){
        return repoClient.save(client);
    }
    
    public void delete(Client client){
        repoClient.delete(client);
    }
    
}
