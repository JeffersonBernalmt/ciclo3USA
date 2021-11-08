package co.edu.usa.reto3.services;

import co.edu.usa.reto3.model.Reservation;
import co.edu.usa.reto3.modelo.custom.CountReservationByTypeClient;
import co.edu.usa.reto3.modelo.custom.StatusAmount;
import co.edu.usa.reto3.repositories.repositories.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
    return reservationRepository.getAll();
    }
    
    public Reservation getById(int id){
    Optional<Reservation> reservation = reservationRepository.getById(id);
    return reservation.orElse(null);
    }
    
    public Reservation save(Reservation reservation){
    return reservationRepository.save(reservation);
    }
    
    public boolean delete(int id) {
        //System.out.println("deleting Reservation with id: " + id);
        boolean d = reservationRepository.getById(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
    
     public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationConsulted = reservationRepository.getById(reservation.getIdReservation());         
            if (reservationConsulted.isPresent()) {
                //System.out.println("si encontro el mensaje con el codigo " + reservation.getIdReservation());
                if (reservation.getStartDate() != null) {
                    reservationConsulted.get().setStartDate(reservation.getStartDate());
                }
                 if (reservation.getDevolutionDate() != null) {
                    reservationConsulted.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return reservationRepository.save(reservationConsulted.get());
            }
        }
        return reservation;
    }
     
     public List<CountReservationByTypeClient> getReservationByTypeClients(){
         return reservationRepository.getReservationByTypeClients();
         
     }
     
     public StatusAmount getStatusReport(){
         List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
         List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
         
         StatusAmount statusAmount = new StatusAmount(completed.size(), cancelled.size());
         return statusAmount;
     }
     
     public List<Reservation> getReservationPeriod(String d1, String d2){
       
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();
        try {
            dateOne = parser.parse(d1);
            dateTwo= parser.parse(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }   
     }

     /** 
     public List<Reservation> getReservationsByPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationByPeriod(a, b);
        } else {
            return new ArrayList<>();
        }
    }
   
    public List<CountReservationByTypeClient> getReservationByTypeClient() {
        return reservationRepository.getReservationByTypeClient();
    }
 */
}
