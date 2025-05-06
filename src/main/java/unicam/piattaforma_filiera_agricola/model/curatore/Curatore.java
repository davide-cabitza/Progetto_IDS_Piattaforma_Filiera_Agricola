package unicam.piattaforma_filiera_agricola.model.curatore;


import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;
import unicam.piattaforma_filiera_agricola.handler.HandlerApprovazioneRichieste;
import unicam.piattaforma_filiera_agricola.model.seller.AccountService;

import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.handler.HandlerApprovazioneRichieste;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;

import java.util.List;

/**
 * Rappresenta un Curatore che supervisiona le richieste di pubblicazione.
 */
public class Curatore extends UtenteLoggato {

    private final HandlerApprovazioneRichieste handler;

    public Curatore(int id, String nomeUtente,
                    String nome,
                    String email, String password, int cellNumber, String indirizzo, Ruolo ruolo) {
        super(id, nomeUtente, nome, email, password, cellNumber, indirizzo, Ruolo.CURATORE);
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

    /**
     * Elimina il profilo del curatore e gestisce eventuali richieste pendenti.
     */
    public void eliminaProfilo() {
        handler.eliminaProfilo();
        AccountService.deleteAccount(getId());
    }
}