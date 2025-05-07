package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.handler.HandlerEvento;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.seller.AccountService;

import java.time.LocalDate;
import java.util.List;

/**
 * Rappresenta un animatore della filiera che può gestire eventi.
 */
public class AnimatoreFiliera extends UtenteLoggato {

    private final HandlerEvento eventoHandler;

    public AnimatoreFiliera(int id, String nomeUtente,
                            String nome,
                            String email, String password, int cellNumber, String indirizzo, Ruolo ruolo) {
        super(id, nomeUtente, nome, email, password, cellNumber, indirizzo, Ruolo.ANIMATORE_FILIERA);
        this.eventoHandler = new HandlerEvento(this);
    }

    /**
     * Restituisce il handler per la gestione degli eventi.
     */
    public HandlerEvento getEventoHandler() {
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
        return eventoHandler.creaEvento(
                dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione
        );
    }

    /**
     * Elimina un evento specifico.
     */
    public void eliminaEvento(Evento evento) {
        eventoHandler.eliminaEvento(evento);
    }

    /**
     * Restituisce la lista degli eventi creati.
     */
    public List<Evento> visualizzaEventiCreati() {
        return eventoHandler.getEventiCreati();
    }

    /**
     * Invia un invito a un venditore per un evento.
     */
    public void inviaInvitoVenditore(Venditore venditore, Evento evento) {
        eventoHandler.inviaInvitoVenditore(venditore, evento);
    }

    /**
     * Elimina il profilo utente e tutti gli eventi.
     */
    public void eliminaProfilo() {
        eventoHandler.eliminaTuttiEventi();
        AccountService.deleteAccount(getId());
    }
}
