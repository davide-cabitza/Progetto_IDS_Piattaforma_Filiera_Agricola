package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Handler centrale per la gestione degli eventi per l'Animatore della filiera.
 * Comprende creazione, modifica, eliminazione e invio inviti.
 */
public class HandlerEvento {
    private final AnimatoreFiliera animatore;
    private final List<Evento> eventiCreati;

    public HandlerEvento(AnimatoreFiliera animatore) {
        this.animatore = animatore;
        this.eventiCreati = new ArrayList<>();
    }

    /**
     * Crea un nuovo evento e lo aggiunge alla lista degli eventi dell'animatore.
     */
    /*
    public Evento creaEvento(LocalDate dataInizio,
                             LocalDate dataFine,
                             String luogo,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        Long idEvento = Long.valueOf(UUID.randomUUID().toString());
        Evento evento = new Evento(
                idEvento,
                dataInizio,
                dataFine,
                nome,
                descrizione,
                maxPartecipanti,
                luogo,

        );
        eventiCreati.add(evento);
        // Logica di persistenza, notifiche, ecc. può essere aggiunta qui
        return evento;
    }

     */

    /**
     * Modifica i dati di un evento esistente.
     */
    public Evento modificaEvento(Evento evento,
                                 LocalDate dataInizio,
                                 LocalDate dataFine,
                                 Indirizzo luogo,
                                 int maxPartecipanti,
                                 String nome,
                                 String descrizione) {
        if (!eventiCreati.contains(evento)) {
            throw new IllegalArgumentException("Evento non gestito da questo animatore");
        }
        evento.setDataInizio(dataInizio);
        evento.setDataFine(dataFine);
        evento.setLuogo(luogo);
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
     * Elimina tutti gli eventi creati dall'animatore.
     */
    public void eliminaTuttiEventi() {
        for (Evento e : new ArrayList<>(eventiCreati)) {
            eliminaEvento(e);
        }
    }

    /**
     * Restituisce la lista immutabile degli eventi creati.
     */
    public List<Evento> getEventiCreati() {
        return Collections.unmodifiableList(eventiCreati);
    }

    /**
     * Invia un invito a un Venditore a partecipare a un evento.
     */
    public void inviaInvitoVenditore(Venditore venditore, Evento evento) {
        if (!eventiCreati.contains(evento)) {
            throw new IllegalArgumentException("Evento non gestito da questo animatore");
        }
        /*
        Invitation invito = new Invitation(
                UUID.randomUUID().toString(),
                animatore,
                venditore,
                evento,
                LocalDateTime.now()
        );
        evento.aggiungiInvito(animatore, venditore);
        venditore.getInviti().add(invito);
         */
    }
}
