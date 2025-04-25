package unicam.piattaforma_filiera_agricola.model.product;

import java.util.Date;

public class ProdottoTrasformatore extends Prodotto {

    public ProdottoTrasformatore(int id, String nomeProdotto, String descrizione, String processoTrasformazione, String certificati, double costo, int quantitativo, int id_venditore, Date dataInserimento) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, id_venditore, dataInserimento);
    }
}
