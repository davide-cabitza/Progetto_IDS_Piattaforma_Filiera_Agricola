package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.curatore.Curatore;
import unicam.piattaforma_filiera_agricola.model.curatore.StatoRichiesta;
import unicam.piattaforma_filiera_agricola.model.curatore.RichiestaPubblicazione;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Gestisce le richieste di pubblicazione per il Curatore.
 */
public class HandlerApprovazioneRichieste {
    private final Curatore curatore;
    private final List<RichiestaPubblicazione> richiesteInAttesa;

    public HandlerApprovazioneRichieste(Curatore curatore) {
        this.curatore = curatore;
        this.richiesteInAttesa = new ArrayList<>();
    }

    public List<RichiestaPubblicazione> getRichiesteInAttesa() {
        return richiesteInAttesa;
    }

    /**
     * Approva la richiesta di pubblicazione, la rimuove dalla lista e ne aggiorna lo stato.
     */
    public void approvaReq(RichiestaPubblicazione req) {
        // Rimuovo la richiesta dalla lista in attesa
        boolean removed = richiesteInAttesa.remove(req);
        if (!removed) {
            throw new IllegalArgumentException("Richiesta non trovata tra quelle in attesa");
        }
        // Aggiorno lo stato
        req.setStato(StatoRichiesta.APPROVATA);
        // Eventuale logica di pubblicazione del contenuto
    }

    /**
     * Rifiuta la richiesta di pubblicazione con una motivazione e la rimuove.
     */
    public void rifiutaReq(RichiestaPubblicazione req, String motivazione) {
        boolean removed = richiesteInAttesa.remove(req);
        if (!removed) {
            throw new IllegalArgumentException("Richiesta non trovata tra quelle in attesa");
        }
        req.setStato(StatoRichiesta.RIFIUTATA);
        req.setMotivazioneRifiuto(motivazione);
    }

    /**
     * Rifiuta tutte le richieste pendenti e pulisce la lista.
     */
    public void eliminaProfilo() {
        for (RichiestaPubblicazione req : new ArrayList<>(richiesteInAttesa)) {
            rifiutaReq(req, "Profilo Curatore eliminato");
        }
    }
}
