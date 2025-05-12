package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.handler.HandlerEvento;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un animatore della filiera che può gestire eventi.
 */
public class AnimatoreFiliera extends UtenteLoggato {

    private List<Evento> eventoCreato=new ArrayList<>();

    public AnimatoreFiliera(String id, String nomeUtente,
                            String nome,
                            String cognome,
                            String email, String password, String cellNumber, Indirizzo indirizzo, Ruolo ruolo) {
        super(id, nomeUtente,cognome, nome, email, password, cellNumber, indirizzo, Ruolo.ANIMATORE_FILIERA);
    }


    /**
     * Crea un nuovo evento.
     */
    public void creaEvento(String idEvento,
            LocalDate dataInizio,
                             LocalDate dataFine,
                             String localita,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        Evento evento= new Evento(idEvento,dataInizio,dataFine,localita,maxPartecipanti, nome,descrizione);
        this.eventoCreato.add(evento);
    }

    public List<Evento> getEventoCreato() {return eventoCreato;}
    public void setEventoCreato(List<Evento> eventoCreato) {this.eventoCreato=eventoCreato;}

    public void invitaVenditore(Venditore venditore, Evento evento) {
        // Logica semplificata: notifica al venditore dell'invito
        System.out.println("Invito inviato a venditore: " + venditore.getUsername()
                + " per partecipare all'evento '" + evento.getNome() + "'.");
    }


}
