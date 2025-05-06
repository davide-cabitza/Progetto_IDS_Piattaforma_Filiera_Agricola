package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Handler per la gestione dei prodotti di un Venditore.
 */
public class HandlerProdotto {
    private final Venditore venditore;
    private final List<Prodotto> prodotti;

    public HandlerProdotto(Venditore venditore) {
        this.venditore = venditore;
        this.prodotti = new ArrayList<>();
    }

    /**
     * Crea un nuovo prodotto e lo aggiunge alla lista del venditore.
     */
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 double prezzo,
                                 List<String> certificazioni) {
        String id = UUID.randomUUID().toString();
        Prodotto p = new Prodotto(id, nome, descrizione, prezzo, certificazioni, venditore);
        prodotti.add(p);
        return p;
    }

    /**
     * Modifica i dati di un prodotto esistente.
     */
    public Prodotto modificaProdotto(Prodotto prodotto,
                                     String nome,
                                     String descrizione,
                                     double prezzo,
                                     List<String> certificazioni) {
        if (!prodotti.contains(prodotto)) {
            throw new IllegalArgumentException("Prodotto non gestito da questo venditore");
        }
        prodotto.setNomeProdotto(nome);
        prodotto.setDescrizione(descrizione);
        prodotto.setPrezzo(prezzo);
        prodotto.setCertificati(certificazioni);
        return prodotto;
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
     * Elimina tutti i prodotti del venditore.
     */
    public void eliminaTuttiProdotti() {
        prodotti.clear();
    }

    /**
     * Restituisce la lista dei prodotti gestiti.
     */
    public List<Prodotto> getProdotti() {
        return new ArrayList<>(prodotti);
    }
}
