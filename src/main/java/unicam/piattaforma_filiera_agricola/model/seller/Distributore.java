package unicam.piattaforma_filiera_agricola.model.seller;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoDistributore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;

/**
 * Rappresenta un Distributore, specializzazione di Venditore
 * che crea pacchetti di prodotti.
 */
@Entity
@DiscriminatorValue("DISTRIBUTORE")
public class Distributore extends Venditore /*implements IAssieme*/ {

    //@ManyToOne
    //private Pacchetto pacchetto = null;
    private String processoDistribuzione;

    public Distributore() {super();}

    public Distributore(String nome, Indirizzo indirizzo, String processoDistribuzione) {
        super(nome, indirizzo);
        this.processoDistribuzione = processoDistribuzione;
    }

    @Override
    public Prodotto createProdotto(String nome, double costo, String descrizione) {
        return new ProdottoDistributore(nome, costo, descrizione, getIndirizzo(), this, processoDistribuzione);

    }

    /*
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

    public Pacchetto getPacchetto() {
        return pacchetto;
    }

    public void setPacchetto(Pacchetto pacchetto) {
        this.pacchetto = pacchetto;
    }

     */

    public String getProcessoDistribuzione() {
        return processoDistribuzione;
    }

    public void setProcessoDistribuzione(String processoDistribuzione) {
        this.processoDistribuzione = processoDistribuzione;
    }
}
