package unicam.piattaforma_filiera_agricola.model.animatore;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerNotifica;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un animatore della filiera che può gestire eventi.
 */
@Entity
public class AnimatoreFiliera{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Evento> eventoCreato = new ArrayList<>();



    public AnimatoreFiliera(String nome) {
        this.nome = nome;
    }

    public AnimatoreFiliera() {
    }

    /**
     * Crea un nuovo evento.
     */
    public void creaEvento(String nomeEvento, String descrizione, int maxPartecipanti, Indirizzo luogo, LocalDate dataFine, List<Venditore> invitati ,HandlerNotifica notificaService) {
        Evento evento= new Evento(nomeEvento, descrizione, maxPartecipanti, luogo, this, dataFine, invitati);
        this.eventoCreato.add(evento);
    }

    public void invitaVenditore(Venditore venditore, Evento evento) {
        // Logica semplificata: notifica al venditore dell'invito
        System.out.println("Invito inviato a venditore: " + venditore.getNome()
                + " per partecipare all'evento '" + evento.getNome() + "'.");
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Evento> getEventoCreato() {
        return eventoCreato;
    }

    public void setEventoCreato(List<Evento> eventoCreato) {
        this.eventoCreato = eventoCreato;
    }
}
