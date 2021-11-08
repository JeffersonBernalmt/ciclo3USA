package co.edu.usa.reto3.web;

import co.edu.usa.reto3.model.Reservation;
import co.edu.usa.reto3.modelo.custom.CountReservationByTypeClient;
import co.edu.usa.reto3.modelo.custom.StatusAmount;
import co.edu.usa.reto3.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Reservation")
//@CrossOrigin(origins="*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        return new ResponseEntity<>(reservationService.delete(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return reservationService.getReservationPeriod(dateTwo, dateTwo);        
    }
    /*
    @GetMapping("/report/reservations-by-type")
    public List<CountReservationByTypeClient> getReservationsByTipo() {
        return reservationService.getReservationByTypeClients();
    }
   */
    @GetMapping("/report-status")
    public List<StatusAmount> getReservationStatus() {
        return (List<StatusAmount>) reservationService.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountReservationByTypeClient> getReservationsByTipo() {
        return reservationService.getReservationByTypeClients();
    }
    
}
