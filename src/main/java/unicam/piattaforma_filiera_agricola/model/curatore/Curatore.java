package unicam.piattaforma_filiera_agricola.model.curatore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

/**
 * Rappresenta un Curatore che supervisiona le richieste di pubblicazione.
 */
@Entity
public class Curatore{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Curatore() {

    }

    public Curatore(String nome) {
        this.name = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    /**
     * Restituisce il handler per la supervisione delle richieste.

    public HandlerApprovazioneRichieste getHandler() {
        return handler;
    }

    /**
     * Approva una richiesta di pubblicazione.

    public void approvaRichiesta(RichiestaPubblicazione req) {
        handler.approvaReq(req);
    }

    /**
     * Rifiuta una richiesta di pubblicazione, specificando la motivazione.

    public void rifiutaRichiesta(RichiestaPubblicazione req, String motivazione) {
        handler.rifiutaReq(req, motivazione);
    }

    /**
     * Recupera la lista delle richieste in attesa.

    public List<RichiestaPubblicazione> getRichiesteInAttesa() {
        return handler.getRichiesteInAttesa();
    }

     */


}