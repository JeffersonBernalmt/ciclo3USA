package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Score;
import co.edu.usa.reto3.repositories.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll(){
    return scoreRepository.getAll();
    }
    
     public Score getById(int id){
    Optional<Score> score = scoreRepository.getById(id);
    //return score.orElse(new Score());
    return score.orElse(null);
    }
    
    public Score save(Score score){
    return scoreRepository.save(score);
    }
    
    public boolean delete(int id) {
        Boolean d = scoreRepository.getById(id).map(product -> {
            scoreRepository.delete(product);
            return true;
        }).orElse(false);
        return d;
    }
}
