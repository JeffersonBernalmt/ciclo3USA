package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.UserAdministator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.UserAdministratorCrudRepository;

@Repository
public class UserAdministratorRepository {
    @Autowired
    private UserAdministratorCrudRepository repoAdministrator;
    
    public List<UserAdministator> getAll(){
        return (List<UserAdministator>)repoAdministrator.findAll();
    }
    
    public Optional<UserAdministator> getById(int id) {
        return repoAdministrator.findById(id);
    }
    
    public UserAdministator save(UserAdministator administrator){
        return repoAdministrator.save(administrator);
    }
    
    public void delete(UserAdministator administrator){
        repoAdministrator.delete(administrator);
    }
    
}
