package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Orthosis;
import co.edu.usa.reto3.repositories.repositories.CategoryRepository;
import co.edu.usa.reto3.repositories.repositories.OrthosisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrthosisService {
    @Autowired
    private OrthosisRepository orthosisRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Orthosis> getAll(){
    return orthosisRepository.getAll();
    }
    
    public Orthosis getById(int id){
    Optional<Orthosis> ortesis = orthosisRepository.getById(id);
    return ortesis.orElse(new Orthosis());
    }
    
    public Orthosis save(Orthosis orthosis){
    return orthosisRepository.save(orthosis);
    }
    
    public boolean delete(int id) {
        Boolean d = orthosisRepository.getById(id).map(orthosis -> {
            orthosisRepository.delete(orthosis);
            return true;
        }).orElse(false);
        return d;
    }
    
    public Orthosis update(Orthosis orthosis) {
        if (orthosis.getId() != null) {
            Optional<Orthosis> orthosisConsulted = orthosisRepository.getById(orthosis.getId());
            if (orthosisConsulted.isPresent()) {
                if (orthosis.getBrand() != null) {
                    orthosisConsulted.get().setBrand(orthosis.getBrand());
                }
                if (orthosis.getName() != null) {
                    orthosisConsulted.get().setName(orthosis.getName());
                }
                if (orthosis.getDescription() != null) {
                    orthosisConsulted.get().setDescription(orthosis.getDescription());
                }
                 if (orthosis.getYear() != null) {
                    orthosisConsulted.get().setYear(orthosis.getYear());
                }
                return orthosisRepository.save(orthosisConsulted.get());
            }
        }
        return orthosis;
    }
    
    
}
