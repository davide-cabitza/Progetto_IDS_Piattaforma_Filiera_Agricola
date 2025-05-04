package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.builder.BuilderProdottoGrezzo;
import unicam.piattaforma_filiera_agricola.model.builder.BuilderProdottoTrasformato;

import java.util.Date;

public class ProdottoTrasformato extends Prodotto {

    private String processoProduttivo;

    public ProdottoTrasformato(String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, int id_venditore, Indirizzo location, String processoProduttivo) {
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
