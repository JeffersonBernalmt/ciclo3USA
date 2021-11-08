package co.edu.usa.reto3.repositories.crud;

import co.edu.usa.reto3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
    //@Query("Select c from Reservation AS c where c.dateReservation > ?1 AND c.dateReservation <?2")
    //public List<Reservation> findAllByDateReservationAfterAndDateReservationBefore(Date dateOne, Date dateTwo);
    
    //@Query("SELECT c.client, COUNT(c.client) from Reservation AS c Group By c.client order by COUNT(c.client) DESC")
    
    //JPQL

    public List<Reservation> findAllByStatus(String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    @Query("select r.client, COUNT(r.client) from Reservation AS r group by r.client order by COUNT(r.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    
}
