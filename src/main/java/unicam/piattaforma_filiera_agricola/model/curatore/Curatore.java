package unicam.piattaforma_filiera_agricola.model.curatore;


import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;
import unicam.piattaforma_filiera_agricola.handler.HandlerApprovazioneRichieste;

import java.util.List;

/**
 * Rappresenta un Curatore che supervisiona le richieste di pubblicazione.
 */
public class Curatore extends UtenteLoggato {

    private final HandlerApprovazioneRichieste handler;

    public Curatore(String id,
                    String username,
                    String nome,
                    String cognome,
                    String email,
                    String password,
                    String cellNumber,
                    Indirizzo indirizzo) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo, Ruolo.CURATORE);
        this.handler = new HandlerApprovazioneRichieste(this);
    }

    /**
     * Restituisce il handler per la supervisione delle richieste.
     */
    public HandlerApprovazioneRichieste getHandler() {
        return handler;
    }

    /**
     * Approva una richiesta di pubblicazione.
     */
    public void approvaRichiesta(RichiestaPubblicazione req) {
        handler.approvaReq(req);
    }

    /**
     * Rifiuta una richiesta di pubblicazione, specificando la motivazione.
     */
    public void rifiutaRichiesta(RichiestaPubblicazione req, String motivazione) {
        handler.rifiutaReq(req, motivazione);
    }

    /**
     * Recupera la lista delle richieste in attesa.
     */
    public List<RichiestaPubblicazione> getRichiesteInAttesa() {
        return handler.getRichiesteInAttesa();
    }


}