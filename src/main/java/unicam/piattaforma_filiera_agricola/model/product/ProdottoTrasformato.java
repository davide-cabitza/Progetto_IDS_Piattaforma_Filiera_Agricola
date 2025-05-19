package unicam.piattaforma_filiera_agricola.model.product;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

@Entity
@DiscriminatorValue("TRASFORMATORE")
public class ProdottoTrasformato extends Prodotto {

    private String processoTrasformazione;

    public ProdottoTrasformato(String nomeProdotto,
                               double costo,
                               String descrizione,
                               Indirizzo indirizzo,
                               Venditore venditore,
                               String processoTrasformazione) {
        super(nomeProdotto, costo, descrizione, indirizzo, venditore);
        this.processoTrasformazione = processoTrasformazione;
    }

    public ProdottoTrasformato() {

    }

    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoProduttivo) {
        this.processoTrasformazione = processoTrasformazione;
    }
}
