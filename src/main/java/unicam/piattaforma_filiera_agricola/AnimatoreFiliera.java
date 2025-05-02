package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class AnimatoreFiliera extends UtenteLoggato {


    private final AnimatoreHandler animatoreHandler;

    public AnimatoreFiliera(String id, String nome, String cognome, String email) {
        super(id, nome, cognome, email, Ruolo.ANIMATORE_FILIERA);
        this.animatoreHandler = new AnimatoreHandler(this);
    }

    // Getter per il handler dell'animatore
    public AnimatoreHandler getAnimatoreHandler() {
        return animatoreHandler;
    }

    /**
     * Crea un nuovo evento delegando ad AnimatoreHandler.
     */
    public Evento creaEvento(LocalDate dataInizio,
                             LocalDate dataFine,
                             String localita,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        return animatoreHandler.creaEvento(dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione);
    }

    /**
     * Modifica un evento esistente.
     */
    public Evento modificaEvento(Evento evento,
                                 LocalDate dataInizio,
                                 LocalDate dataFine,
                                 String localita,
                                 int maxPartecipanti,
                                 String nome,
                                 String descrizione) {
        return animatoreHandler.modificaEvento(evento, dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione);
    }

    /**
     * Elimina un singolo evento specificato.
     */
    public void eliminaEvento(Evento evento) {
        animatoreHandler.eliminaEvento(evento);
    }

    /**
     * Invita un Venditore a partecipare a un evento.
     */
    public void invitaVenditore(Venditore venditore, Evento evento) {
        animatoreHandler.inviaInvitoVenditore(venditore, evento);
    }

    /**
     * Restituisce la lista degli eventi creati dall'AnimatoreFiliera.
     */
    public List<Evento> visualizzaEventiCreati() {
        return animatoreHandler.getEventiCreati();
    }

    /**
     * Elimina il profilo dell'AnimatoreFiliera insieme a tutti gli eventi creati.
     */
    public void eliminaProfilo() {
        animatoreHandler.eliminaTuttiEventi();
        AccountService.deleteAccount(getId());
    }
}

}
