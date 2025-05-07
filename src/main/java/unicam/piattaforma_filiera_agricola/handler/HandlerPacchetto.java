// File: HandlerPacchetto.java
package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.seller.Distributore;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Handler per la gestione dei pacchetti creati dal Distributore.
 */
public class HandlerPacchetto {
    private final Distributore distributore;
    private final List<Pacchetto> pacchetti;

    public HandlerPacchetto(Distributore distributore) {
        this.distributore = distributore;
        this.pacchetti = new ArrayList<>();
    }

    /**
     * Crea un nuovo pacchetto di prodotti.
     * @param nome          nome del pacchetto
     * @param prodotti      lista di prodotti
     * @param prezzoTotale  prezzo complessivo del pacchetto
     * @return pacchetto creato
     */
    public Pacchetto creaPacchetto(String nome, List<Prodotto> prodotti, double prezzoTotale) {
        String id = UUID.randomUUID().toString();
        Pacchetto pacchetto = new Pacchetto(id, nome, prodotti, prezzoTotale, distributore);
        pacchetti.add(pacchetto);
        return pacchetto;
    }

    /**
     * Modifica il nome e/o prezzo di un pacchetto esistente.
     */
    public void modificaPacchetto(Pacchetto pacchetto, String nuovoNome, double nuovoPrezzo) {
        if (!pacchetti.contains(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non gestito da questo distributore");
        }
        pacchetto.setNome(nuovoNome);
        pacchetto.setPrezzoTotale(nuovoPrezzo);
    }

    /**
     * Elimina un pacchetto.
     */
    public void eliminaPacchetto(Pacchetto pacchetto) {
        if (!pacchetti.remove(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non trovato");
        }
    }

    /**
     * Elimina tutti i pacchetti creati dal distributore.
     */
    public void eliminaTuttiPacchetti() {
        pacchetti.clear();
    }

    /**
     * Restituisce la lista dei pacchetti.
     */
    public List<Pacchetto> getPacchetti() {
        return Collections.unmodifiableList(pacchetti);
    }
}
