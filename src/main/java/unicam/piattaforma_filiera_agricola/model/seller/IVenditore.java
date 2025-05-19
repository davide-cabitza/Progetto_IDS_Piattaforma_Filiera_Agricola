package unicam.piattaforma_filiera_agricola.model.seller;


import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

/**
 * Interfaccia che definisce le operazioni di caricamento di un prodotto da parte di un venditore.
 */
public interface IVenditore {

    /**
     * Carica un nuovo prodotto con le informazioni specificate.
     *
     * @param name          Nome del prodotto.
     * @param description   Descrizione del prodotto.
     * @param certification Certidicazioni del prodotto.
     * @param price         Prezzo del prodotto.
     * @param quantity      Quantità del prodotto disponibile.
     * @param id_venditore  Id del venditore del prodotto.
     * @param adress        Indirizzo dell'azienda che vende il prodotto.
     * @return Prodotto     oggetto Prodotto con le informazioni sul prodotto.
     */
    public Prodotto createProduct(String name,
                                  String description,
                                  String certification, double price, int quantity, int id_venditore, Indirizzo adress);
}