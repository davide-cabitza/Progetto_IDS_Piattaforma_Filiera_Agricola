package unicam.piattaforma_filiera_agricola.model.seller;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoGrezzo;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

@Entity
@DiscriminatorValue("PRODUTTORE")
public class Produttore extends Venditore{

    private String processoColtivazione;

    public Produttore() {
        super();
    }

    public Produttore(String nome, Indirizzo indirizzo, String processoColtivazione) {
        super(nome, indirizzo);
        this.processoColtivazione = processoColtivazione;
    }

    @Override
    public Prodotto createProdotto(String nome, double costo, String descrizione) {
        return new ProdottoGrezzo(nome, costo, descrizione, getIndirizzo(), this, processoColtivazione);
    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoColtivazione) {
        this.processoColtivazione = processoColtivazione;
    }

}
