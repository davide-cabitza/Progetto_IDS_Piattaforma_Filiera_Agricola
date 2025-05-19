package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

public class ProdottoGrezzo extends Prodotto {

    private String processoDiColtivazione;

    public ProdottoGrezzo(String id, String nomeProdotto, double costo, String descrizione, String certificati , Indirizzo indirizzo, int id_venditore, double prezzo, int quantita, String ProcessodiColtivazione) {
        super(id, nomeProdotto,descrizione, certificati, indirizzo, id_venditore, prezzo, quantita);
        this.processoDiColtivazione = processoDiColtivazione;
    }

    public String getProcessoDiColtivazione() {
        return processoDiColtivazione;
    }

    public void setProcessoDiColtivazione(String processoDiColtivazione) {
        this.processoDiColtivazione = processoDiColtivazione;
    }
}
