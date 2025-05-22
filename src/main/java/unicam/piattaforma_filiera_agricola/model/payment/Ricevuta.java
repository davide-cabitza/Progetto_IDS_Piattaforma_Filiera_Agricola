package unicam.piattaforma_filiera_agricola.model.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ricevuta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descrizione;

    public Ricevuta() {}

    public Ricevuta(String descrizione) {
        this.descrizione = descrizione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
