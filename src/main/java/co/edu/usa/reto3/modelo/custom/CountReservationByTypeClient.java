package co.edu.usa.reto3.modelo.custom;

import co.edu.usa.reto3.model.Client;
import java.io.Serializable;

public class CountReservationByTypeClient implements Serializable{
    
    //private String typeClient;
    //private Long quantity;
    
    private Integer total;
    private Client client;

    public CountReservationByTypeClient(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    

 
}
