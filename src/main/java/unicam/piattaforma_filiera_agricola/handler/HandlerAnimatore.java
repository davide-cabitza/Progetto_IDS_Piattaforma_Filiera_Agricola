package unicam.piattaforma_filiera_agricola.handler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.model.animatore.Invitation;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

public class HandlerAnimatore {
    private final AnimatoreFiliera animatore;
    private final List<Evento> eventiCreati;

    public HandlerAnimatore(AnimatoreFiliera animatore) {
        this.animatore = animatore;
        this.eventiCreati = new ArrayList<>();
    }

    /**
     * Crea un nuovo evento e lo aggiunge alla lista degli eventi dell'animatore.
     */
    public Evento creaEvento(LocalDate dataInizio,
                             LocalDate dataFine,
                             String localita,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        Evento evento = new Evento(dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione, animatore);
        eventiCreati.add(evento);
        // Logica di persistenza, notifiche, ecc. può essere aggiunta qui
        return evento;
    }

    /**
     * Modifica un evento esistente con i nuovi dati forniti.
     */
    public Evento modificaEvento(Evento evento,
                                 LocalDate dataInizio,
                                 LocalDate dataFine,
                                 String localita,
                                 int maxPartecipanti,
                                 String nome,
                                 String descrizione) {
        if (!eventiCreati.contains(evento)) {
            throw new IllegalArgumentException("Evento non gestito da questo animatore");
        }
        evento.setDataInizio(dataInizio);
        evento.setDataFine(dataFine);
        evento.setLocalita(localita);
        evento.setMaxPartecipanti(maxPartecipanti);
        evento.setNome(nome);
        evento.setDescrizione(descrizione);
        // Aggiorna persistenza se necessario
        return evento;
    }

    /**
     * Elimina un singolo evento.
     */
    public void eliminaEvento(Evento evento) {
        if (eventiCreati.remove(evento)) {
            // Logica di rimozione da DB, notifiche, ecc.
        } else {
            throw new IllegalArgumentException("Evento non trovato tra quelli creati");
        }
    }

    /**
     * Restituisce la lista degli eventi creati.
     */
    public List<Evento> getEventiCreati() {
        return Collections.unmodifiableList(eventiCreati);
    }

    /**
     * Invita un venditore a partecipare ad un evento.
     */
    public void inviaInvitoVenditore(Venditore venditore, Evento evento) {
        if (!eventiCreati.contains(evento)) {
            throw new IllegalArgumentException("Evento non gestito da questo animatore");
        }
        Invitation invito = new Invitation(animatore, venditore, evento);
        // Logica di invio invito (email, notifica..) va qui
        venditore.getEventiInvitati().add(invito);
    }

    /**
     * Elimina tutti gli eventi creati dall'animatore.
     */
    public void eliminaTuttiEventi() {
        for(Evento e : new ArrayList<>(eventiCreati)) {
            eliminaEvento(e);
        }
    }
}
