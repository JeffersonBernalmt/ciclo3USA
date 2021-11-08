package co.edu.usa.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
      
    @ManyToOne
    @JoinColumn(name="idOrtopedics", nullable = true)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Orthosis ortopedic;
    
    @ManyToOne
    @JoinColumn(name="idClient", nullable = true)
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;
    
  

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Orthosis getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Orthosis ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
