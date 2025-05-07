package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import java.util.List;

/**
 * Rappresenta un Trasformatore (specializzazione di Venditore)
 * che applica un processo di trasformazione ai prodotti.
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
                         String indirizzo,
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
     * Crea e pubblica un nuovo prodotto delegando a Venditore,
     * aggiungendo il processo di trasformazione.
     */
    @Override
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 double prezzo,
                                 List<String> certificazioni) {
        Prodotto p = super.creaProdotto(nome, descrizione, prezzo, certificazioni);
        p.setProcessoTrasformazione(processoTrasformazione);
        return p;
    }


    /**
     * Elimina un prodotto delegando a Venditore.
     */
    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        super.eliminaProdotto(prodotto);
    }

    /**
     * Elimina il profilo e rimuove tutti i prodotti.
     */
    @Override
    public void eliminaProfilo() {
        super.eliminaProfilo();
    }
}
