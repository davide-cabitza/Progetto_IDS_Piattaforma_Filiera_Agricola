package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

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


    /**
     * Crea un nuovo prodotto.
     */
    @Override
    public Prodotto createProdotto(String nome,
                                   String descrizione,
                                   String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
        return prodottoHandler.creaProdotto(nome, descrizione, certificazioni, indirizzo, id_venditore, prezzo, quantitativo);
    }


}
