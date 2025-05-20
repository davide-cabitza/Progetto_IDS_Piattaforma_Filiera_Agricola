package unicam.piattaforma_filiera_agricola.model.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

@Entity
@DiscriminatorValue("DISTRIBUTORE")
public class ProdottoDistributore extends Prodotto {
    private String processoDistribuzione;

    public ProdottoDistributore(String nomeProdotto,
                                double costo,
                                String descrizione,
                                Indirizzo indirizzo,
                                Venditore venditore,
                                String processoDistribuzione) {
        super(nomeProdotto, costo, descrizione, indirizzo, venditore);
        this.processoDistribuzione = processoDistribuzione;
    }

    public ProdottoDistributore() {

    }

    public String getProcessoDistribuzione() {
        return processoDistribuzione;
    }

    public void setProcessoDistribuzione(String processoDistribuzione) {
        this.processoDistribuzione = processoDistribuzione;
    }
}
