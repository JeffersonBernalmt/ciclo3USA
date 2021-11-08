package co.edu.usa.reto3.repositories.repositories;

import co.edu.usa.reto3.model.Client;
import co.edu.usa.reto3.model.Reservation;
import co.edu.usa.reto3.modelo.custom.CountReservationByTypeClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositories.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository repoReservation;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)repoReservation.findAll();
    }
    
    public Optional<Reservation> getById(int id) {
        return repoReservation.findById(id);
    }
    
    public Reservation save(Reservation reservation){
        return repoReservation.save(reservation);
    }
    
    public void delete(Reservation reservation){
        repoReservation.delete(reservation);
    }
    
    public List<Reservation> getReservationByStatus(String status) {
        return repoReservation.findAllByStatus(status);
    }
    
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo) {
        return repoReservation.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }
    
    /**
     public List<Reservation> getReservationByPeriod(Date a, Date b) {
        return repoReservation.findAllByDateReservationAfterAndDateReservationBefore(a, b);
    }
      */
    
     public List<CountReservationByTypeClient> getReservationByTypeClients(){
         
         List<CountReservationByTypeClient> res = new ArrayList<>();
         
         List<Object[]> report = repoReservation.countTotalReservationByClient();
         
         for (int i = 0; i < report.size(); i++) {
             /*
             Client client = (Client) report.get(i)[0];
             Integer cantidad = (Integer) report.get(i)[1];
             CountReservationByTypeClient cc = new CountReservationByTypeClient (cantidad, client);
             res.add(cc);
             */
             res.add(new CountReservationByTypeClient ((Integer) report.get(i)[1], (Client)report.get(i)[0]));
             
            //Object[] linea = report.get(i);
            //res.add(new CountReservationByTypeClient(linea[0].toString(), (Long) linea[1]));
        }
        return res;
    }
   
}