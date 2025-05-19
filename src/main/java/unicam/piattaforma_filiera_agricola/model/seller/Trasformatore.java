package unicam.piattaforma_filiera_agricola.model.seller;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoTrasformato;

/**
 * Rappresenta un Trasformatore, estensione di Venditore,
 * che applica un processo di trasformazione ai prodotti pubblicati.
 */
@Entity
@DiscriminatorValue("TRASFORMATORE")
public class Trasformatore extends Venditore {

    private String processoTrasformazione;

    public Trasformatore() {super();}

    public Trasformatore(String nome, Indirizzo indirizzo, Prodotto prodotto) {
        super(nome, indirizzo);
        this.processoTrasformazione = processoTrasformazione;
    }

    @Override
    public Prodotto createProdotto(String nome, double prezzo, String descrizione) {
        return new ProdottoTrasformato(nome, prezzo, descrizione, getIndirizzo(), this, processoTrasformazione);

    }

    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoTrasformazione) {
        this.processoTrasformazione = processoTrasformazione;
    }

}
