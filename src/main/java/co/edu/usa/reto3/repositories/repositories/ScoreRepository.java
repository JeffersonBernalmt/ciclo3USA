package co.edu.usa.reto3.repositories.repositories;
//se importa la entidad y el extends del crud repository
import co.edu.usa.reto3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository repoScore;
    
    public List<Score> getAll(){
        return (List<Score>)repoScore.findAll();
    }
    
    public Optional<Score> getById(int id) {
        return repoScore.findById(id);
    }
    
    public Score save(Score score){
        return repoScore.save(score);
    }
    
    public void delete(Score score){
        repoScore.delete(score);
    }
    
}
