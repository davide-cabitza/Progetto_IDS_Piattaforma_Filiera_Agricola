package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.Indirizzo;

import java.util.Date;
import java.util.List;

public class ProdottoGrezzo extends Prodotto {

    private String processoProduttivo;

    public ProdottoGrezzo(String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, int id_venditore, Indirizzo location, String processoProduttivo) {
        super(nomeProdotto, descrizione, certificati, costo, quantitativo, id_venditore, location);
        this.processoProduttivo = processoProduttivo;
    }

    public String getProcessoProduttivo() {
        return processoProduttivo;
    }

    public void setProcessoProduttivo(String processoProduttivo) {
        this.processoProduttivo = processoProduttivo;
    }
}
