package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.seller.AccountService;
import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import java.util.List;

/**
 * Rappresenta un Venditore generico (Produttore, Distributore, Trasformatore).
 */
public class Venditore extends UtenteLoggato {
    private final HandlerProdotto prodottoHandler;

    public Venditore(String id,
                     String username,
                     String nome,
                     String cognome,
                     String email,
                     String password,
                     String cellNumber,
                     String indirizzo) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo, Ruolo.VENDITORE);
        this.prodottoHandler = new HandlerProdotto(this);
    }

    /**
     * Crea un nuovo prodotto.
     */
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 double prezzo,
                                 List<String> certificazioni) {
        return prodottoHandler.creaProdotto(nome, descrizione, prezzo, certificazioni);
    }

    /**
     * Modifica un prodotto esistente.
     */
    public Prodotto modificaProdotto(Prodotto prodotto,
                                     String nome,
                                     String descrizione,
                                     double prezzo,
                                     List<String> certificazioni) {
        return prodottoHandler.modificaProdotto(prodotto, nome, descrizione, prezzo, certificazioni);
    }

    /**
     * Elimina un prodotto.
     */
    public void eliminaProdotto(Prodotto prodotto) {
        prodottoHandler.eliminaProdotto(prodotto);
    }

    /**
     * Elimina il profilo del venditore e tutti i suoi prodotti.
     */
    public void eliminaProfilo() {
        prodottoHandler.eliminaTuttiProdotti();
        AccountService.deleteAccount(getId());
    }
}
