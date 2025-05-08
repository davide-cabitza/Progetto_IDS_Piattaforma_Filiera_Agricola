package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.Indirizzo;
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
                                 String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
        return prodottoHandler.creaProdotto(nome, descrizione, certificazioni, prezzo, quantitativo, id_venditore, indirizzo);
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
