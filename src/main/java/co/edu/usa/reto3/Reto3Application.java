package co.edu.usa.reto3;
//importaciones de las entidades
import co.edu.usa.reto3.model.Score;
import co.edu.usa.reto3.model.Category;
import co.edu.usa.reto3.model.Client;
import co.edu.usa.reto3.model.Message;
import co.edu.usa.reto3.model.Orthosis;
import co.edu.usa.reto3.model.Reservation;
import co.edu.usa.reto3.model.UserAdministator;
//importaciones de los repositorios
import co.edu.usa.reto3.repositories.repositories.ScoreRepository;
import co.edu.usa.reto3.repositories.repositories.CategoryRepository;
import co.edu.usa.reto3.repositories.repositories.ClientRepository;
import co.edu.usa.reto3.repositories.repositories.MessageRepository;
import co.edu.usa.reto3.repositories.repositories.OrthosisRepository;
import co.edu.usa.reto3.repositories.repositories.ReservationRepository;
import co.edu.usa.reto3.repositories.repositories.UserAdministratorRepository;
//importacion java
import java.util.List;
//importaciones de Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.reto3"})
public class Reto3Application {
        
        @Autowired
        private ScoreRepository repoScore;
        @Autowired
        private CategoryRepository repoCategory;
        @Autowired
        private ClientRepository repoClient;
        @Autowired
        private MessageRepository repoMessage;
        @Autowired
        private OrthosisRepository repoOrthosis;
        @Autowired
        private ReservationRepository repoReservation;
        @Autowired
        private UserAdministratorRepository repoUserAdministrator;
        
        //se ejecuta el proyecto
        public static void main(String[] args) {
	SpringApplication.run(Reto3Application.class, args);
        }

        @Bean
        ApplicationRunner applicationRunner() {
        return args -> {
            List<Score> cals = repoScore.getAll();
            System.out.println("Scores: "+cals.size());
            
            List<Category> cats = repoCategory.getAll();
            System.out.println("Categories: "+cats.size());
            
            List<Client> clis = repoClient.getAll();
            System.out.println("Clients: "+clis.size());
            
            List<Message> mens = repoMessage.getAll();
            System.out.println("Messages: "+mens.size());
            
            List<Orthosis> orts = repoOrthosis.getAll();
            System.out.println("Orthosis: "+orts.size());
            
            List<Reservation> ress = repoReservation.getAll();
            System.out.println("Reservations: "+ress.size());
            
            List<UserAdministator> adms = repoUserAdministrator.getAll();
            System.out.println("Administrators: "+adms.size());
        };
    }
        
}
