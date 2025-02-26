package unicam.piattaforma_filiera_agricola.product;

import java.util.Date;

public class ProdottoProduttore extends Prodotto {

    public ProdottoProduttore(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, String categoria, int id_venditore, Date dataInserimento) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, categoria, id_venditore, dataInserimento);
    }
}
