package unicam.piattaforma_filiera_agricola.model.seller;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Date;

public interface IAssieme {

    void assiemeProdotti(String nomeAssieme, double prezzo, String descrizione);

    /**
     * Aggiunge un sottoprodotto al bundle in costruzione.
     *
     */
    void aggiungiProdotto(Prodotto prodotto);

    /**
     * Conclude la costruzione del bundle e restituisce il prodotto finale.
     *
     * @return Il prodotto finale del bundle.
     */
    Prodotto assiemeFinito();
}

