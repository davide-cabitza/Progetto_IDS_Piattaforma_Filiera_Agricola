package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

public class ProdottoGrezzo extends Prodotto {

    private String processoDiColtivazione;

    public ProdottoGrezzo(String nomeProdotto, double costo, String descrizione, Indirizzo indirizzo, Venditore venditore, String ProcessodiColtivazione) {
        super(nomeProdotto, costo, descrizione,indirizzo, venditore);
        this.processoDiColtivazione = processoDiColtivazione;
    }

    public String getProcessoDiColtivazione() {
        return processoDiColtivazione;
    }

    public void setProcessoDiColtivazione(String processoDiColtivazione) {
        this.processoDiColtivazione = processoDiColtivazione;
    }
}
