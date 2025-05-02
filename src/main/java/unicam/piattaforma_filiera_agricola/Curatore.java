package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curatore extends UtenteLoggato implements IValidate{


    private final List<RichiestaPubblicazione> richiesteInAttesa;

    public Curatore(String id, String nome, String cognome, String email) {
        super(id, nome, cognome, email, Ruolo.CURATORE);
        this.richiesteInAttesa = new ArrayList<>();
    }

    // Getter per le richieste di pubblicazione in attesa
    public List<RichiestaPubblicazione> getRichiesteInAttesa() {
        return Collections.unmodifiableList(richiesteInAttesa);
    }

    /**
     * Aggiunge una richiesta di pubblicazione alla lista di quelle da supervisionare.
     */
    public void aggiungiRichiesta(RichiestaPubblicazione richiesta) {
        richiesteInAttesa.add(richiesta);
    }

    /**
     * Approva una richiesta di pubblicazione.
     */
    public void approvaRichiesta(RichiestaPubblicazione richiesta) {
        if (!richiesteInAttesa.remove(richiesta)) {
            throw new IllegalArgumentException("Richiesta non trovata tra quelle in attesa");
        }
        richiesta.setStato(StatoRichiesta.APPROVATA);
        // Logica di pubblicazione del contenuto
    }

    /**
     * Rifiuta una richiesta di pubblicazione.
     * @param richiesta  la richiesta da rifiutare
     * @param motivazione spiegazione del rifiuto
     */
    public void rifiutaRichiesta(RichiestaPubblicazione richiesta, String motivazione) {
        if (!richiesteInAttesa.remove(richiesta)) {
            throw new IllegalArgumentException("Richiesta non trovata tra quelle in attesa");
        }
        richiesta.setStato(StatoRichiesta.RIFIUTATA);
        richiesta.setMotivazioneRifiuto(motivazione);
        // Eventuale notifica al richiedente
    }

    /**
     * Elimina il profilo del Curatore e pulisce le richieste pendenti.
     */
    public void eliminaProfilo() {
        // Rifiuta tutte le richieste in attesa
        for (RichiestaPubblicazione req : new ArrayList<>(richiesteInAttesa)) {
            rifiutaRichiesta(req, "Profilo Curatore eliminato");
        }
        AccountService.deleteAccount(getId());
    }
