package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;

import java.time.LocalDate;
import java.util.List;

public class AnimatoreFiliera extends UtenteLoggato {


    private final HandleCreazioneEvento eventoHandler;

    public AnimatoreFiliera(String id, String nome, String cognome, String email) {
        super(id, nome, cognome, email, Ruolo.ANIMATORE_FILIERA);
        this.eventoHandler = new HandleCreazioneEvento(this);
    }

    public HandleCreazioneEvento getEventoHandler() {
        return eventoHandler;
    }

    /**
     * Crea un nuovo evento.
     */
    public Evento creaEvento(LocalDate dataInizio,
                             LocalDate dataFine,
                             String localita,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        return eventoHandler.creaEvento(dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione);
    }

    /**
     * Modifica i dati di un evento esistente.
     */
    public Evento modificaEvento(Evento evento,
                                 LocalDate dataInizio,
                                 LocalDate dataFine,
                                 String localita,
                                 int maxPartecipanti,
                                 String nome,
                                 String descrizione) {
        return eventoHandler.modificaEvento(evento, dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione);
    }

    /**
     * Elimina un evento specifico.
     */
    public void eliminaEvento(Evento evento) {
        eventoHandler.eliminaEvento(evento);
    }

    /**
     * Recupera la lista degli eventi creati.
     */
    public List<Evento> visualizzaEventiCreati() {
        return eventoHandler.getEventiCreati();
    }

    /**
     * Elimina il profilo utente e tutti gli eventi.
     */
    public void eliminaProfilo() {
        eventoHandler.eliminaTuttiEventi();
        AccountService.deleteAccount(getId());
    }
}

