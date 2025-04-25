package unicam.piattaforma_filiera_agricola.model.product;

import java.util.Date;

public class ProdottoProduttore extends Prodotto {

    public ProdottoProduttore(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, int id_venditore, Date dataInserimento) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, id_venditore, dataInserimento);
    }
}
