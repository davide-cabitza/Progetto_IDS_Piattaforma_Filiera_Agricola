package unicam.piattaforma_filiera_agricola.model.product;

import java.util.Date;

public class ProdottoGrezzo extends Prodotto {

    private String processoProduttivo;

    public ProdottoGrezzo(int id, String nomeProdotto, String descrizione, String processoProduttivo, String certificati, double costo, int quantitativo, int id_venditore, Date dataInserimento) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, id_venditore, dataInserimento);
        this.processoProduttivo = processoProduttivo;
    }
}
