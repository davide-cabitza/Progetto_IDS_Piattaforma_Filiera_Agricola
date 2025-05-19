package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.seller.Distributore;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Handler per la gestione dei prodotti di un Venditore.
 */
public class HandlerProdotto {
    private final Venditore venditore;
    private final List<Prodotto> prodotti;
    private final List<Pacchetto> pacchetti;


    public HandlerProdotto(Venditore venditore) {
        this.venditore = venditore;
        this.prodotti = new ArrayList<>();
        this.pacchetti = new ArrayList<>();
    }

    /**
     * Crea un nuovo prodotto e lo aggiunge alla lista del venditore.
     */
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 double prezzo) {
        /*
    }
        String id = UUID.randomUUID().toString();
        Prodotto p = new Prodotto(nome,descrizione,prezzo);
                                 String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
        String id = UUID.randomUUID().toString();
        Prodotto p = new Prodotto(nome, descrizione, certificazioni, prezzo, quantitativo, id_venditore, indirizzo);
        p.setId(id);
        prodotti.add(p);
        return p;

         */
        return new Prodotto(nome, descrizione, prezzo);
    }


    /**
     * Crea un nuovo pacchetto di prodotti.
     * @param nome          nome del pacchetto
     * @param prodotti      lista di prodotti
     * @param prezzoTotale  prezzo complessivo del pacchetto
     * @return pacchetto creato
     */
    /*
    public Pacchetto creaPacchetto(String nome, List<Prodotto> prodotti, double prezzoTotale) {

        String id = UUID.randomUUID().toString();
        Pacchetto pacchetto = new Pacchetto(id, nome, prodotti, prezzoTotale, (Distributore) venditore);
        pacchetti.add(pacchetto);
        return pacchetto;


    }

     */

    /**
     * Modifica i dati di un prodotto esistente.
     */
    /*
    public Prodotto modificaProdotto(Prodotto prodotto,
                                     String nome,
                                     String descrizione,
                                     double prezzo,
                                     String certificazioni) {
        if (!prodotti.contains(prodotto)) {
            throw new IllegalArgumentException("Prodotto non gestito da questo venditore");
        }
        prodotto.setNomeProdotto(nome);
        prodotto.setDescrizione(descrizione);
        prodotto.setPrezzo(prezzo);
        prodotto.setCertificati(certificazioni);
        return prodotto;
    }

     */


    /**
     * Modifica il nome e/o prezzo di un pacchetto esistente.
     */
    public void modificaPacchetto(Pacchetto pacchetto, String nuovoNome, double nuovoPrezzo) {
        if (!pacchetti.contains(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non gestito da questo distributore");
        }
        /*
        pacchetto.setNome(nuovoNome);
        pacchetto.setPrezzoTotale(nuovoPrezzo);

         */
    }


    /**
     * Elimina un prodotto dalla lista del venditore.
     */
    public void eliminaProdotto(Prodotto prodotto) {
        if (!prodotti.remove(prodotto)) {
            throw new IllegalArgumentException("Prodotto non trovato");
        }
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
     * Elimina tutti i prodotti del venditore.
     */
    public void eliminaTuttiProdotti() {
        prodotti.clear();
    }


    /**
     * Elimina tutti i pacchetti creati dal distributore.
     */
    public void eliminaTuttiPacchetti() {
        pacchetti.clear();
    }


    /**
     * Restituisce la lista dei prodotti gestiti.
     */
    public List<Prodotto> getProdotti() {
        return new ArrayList<>(prodotti);
    }

    /**
     * Restituisce la lista dei pacchetti.
     */
    public List<Pacchetto> getPacchetti() {
        return Collections.unmodifiableList(pacchetti);
    }


}
