package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.Indirizzo;
import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.platform.Marketplace;

import java.util.Map;

/**
 * Classe astratta per tutti i Venditori (Produttore, Distributore, Trasformatore).
 */
public abstract class Venditore extends UtenteLoggato implements IVenditore {

    protected final HandlerProdotto prodottoHandler;

    public Venditore(String id,
                     String username,
                     String nome,
                     String cognome,
                     String email,
                     String password,
                     String cellNumber,
                     Indirizzo indirizzo) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo, Ruolo.VENDITORE);
        this.prodottoHandler = new HandlerProdotto(this);
    }

    public abstract Prodotto createProduct(String name, double price, String description);

    @Override
    public void loadProduct(String name, double price, String description) {
        Prodotto product = createProduct(name, price, description);
    }
    /**
     * Crea un nuovo prodotto.
     */
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
        return prodottoHandler.creaProdotto(nome, descrizione, certificazioni, prezzo, quantitativo, id_venditore, indirizzo);
    }


}
