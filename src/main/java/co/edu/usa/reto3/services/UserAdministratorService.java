package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.UserAdministator;
import co.edu.usa.reto3.repositories.repositories.UserAdministratorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdministratorService {
    @Autowired
    private UserAdministratorRepository usuarioAdmRepository;
    
    public List<UserAdministator> getAll(){
    return usuarioAdmRepository.getAll();
    }
    
    public UserAdministator getById(int id){
    Optional<UserAdministator> usuAdmn = usuarioAdmRepository.getById(id);
    return usuAdmn.orElse(new UserAdministator());
    }
    
    public UserAdministator save(UserAdministator usuarioAdmn){
    return usuarioAdmRepository.save(usuarioAdmn);
    }
    
    public boolean delete(int id) {
        Boolean d = usuarioAdmRepository.getById(id).map(producto -> {
            usuarioAdmRepository.delete(producto);
            return true;
        }).orElse(false);
        return d;
    }
    
}
