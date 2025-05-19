package unicam.piattaforma_filiera_agricola.model.seller;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Rappresenta un Distributore, specializzazione di Venditore
 * che crea pacchetti di prodotti.
 */
@Entity
@DiscriminatorValue("DISTRIBUTORE")
public class Distributore extends Venditore implements IAssieme {

    @ManyToOne
    private Pacchetto pacchetto = null;
    private String processoDistribuzione;

    public Distributore() {super();}

    public Distributore(String nome, Indirizzo indirizzo, String processoDistribuzione) {
        super(nome, indirizzo);
        this.processoDistribuzione = processoDistribuzione;
    }

    public void assiemeProdotti(String bundleName, double price, String description) {
        this.pacchetto = new Pacchetto(bundleName, price, description, getIndirizzo(), this, null);
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (this.pacchetto != null && prodotto != null) {
            this.pacchetto.aggiungiProdotto(prodotto);
        } else {
            System.out.println("Errore: nessun pacchetto in corso oppure subProduct nullo.");
        }
    }

    public Prodotto assiemeFinito() {
        if (this.pacchetto == null) {
            System.out.println("Nessun pacchetto in corso.");
            return null;
        }
        Prodotto assiemefinito = this.pacchetto;
        this.pacchetto = null;
        return assiemefinito;
    }

    @Override
    public Prodotto createProdotto(String name, double price, String description) {
        return new Pacchetto(name, price, description, getIndirizzo(), this, null);

    }
}
