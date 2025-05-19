package unicam.piattaforma_filiera_agricola.model.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

@Entity
@DiscriminatorValue("PRODUTTORE")
public class ProdottoGrezzo extends Prodotto {

    private String processoColtivazione;

    public ProdottoGrezzo(String nomeProdotto,
                          double costo,
                          String descrizione,
                          Indirizzo indirizzo,
                          Venditore venditore,
                          String processodiColtivazione) {
        super(nomeProdotto, costo, descrizione,indirizzo, venditore);
        this.processoColtivazione = processodiColtivazione;
    }

    public ProdottoGrezzo() {

    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoDiColtivazione) {
        this.processoColtivazione = processoDiColtivazione;
    }
}
