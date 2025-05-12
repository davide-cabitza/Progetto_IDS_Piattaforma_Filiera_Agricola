package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoTrasformato;

import java.util.Date;
import java.util.List;

/**
 * Rappresenta un Trasformatore, estensione di Venditore,
 * che applica un processo di trasformazione ai prodotti pubblicati.
 */
public class Trasformatore extends Venditore {

    private String processoTrasformazione;

    public Trasformatore(String id,
                         String username,
                         String nome,
                         String cognome,
                         String email,
                         String password,
                         String cellNumber,
                         Indirizzo indirizzo,
                         String processoTrasformazione) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo);
        this.processoTrasformazione = processoTrasformazione;
    }

    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoTrasformazione) {
        this.processoTrasformazione = processoTrasformazione;
    }

    /**
     * Crea e pubblica un nuovo prodotto includendo il processo di trasformazione.
     */
    @Override
    public Prodotto createProduct(String nome, double prezzo, String descrizione) {
        return new ProdottoTrasformato(nome, prezzo, descrizione, getIndirizzo(), this, processoTrasformazione);
    }
}
