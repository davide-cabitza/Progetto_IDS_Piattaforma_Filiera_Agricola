package unicam.piattaforma_filiera_agricola.model.seller;


/**
 * Interfaccia che definisce le operazioni di caricamento di un prodotto da parte di un venditore.
 */
public interface IVenditore {

    /**
     * Carica un nuovo prodotto con le informazioni specificate.
     *
     * @param name Nome del prodotto.
     * @param price Prezzo del prodotto.
     * @param description Descrizione del prodotto.
     */
    void loadProduct(String name, double price, String description);
}