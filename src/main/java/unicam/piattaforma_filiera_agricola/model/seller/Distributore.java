package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

/**
 * Rappresenta un Distributore, specializzazione di Venditore
 * che crea pacchetti di prodotti.
 */
public class Distributore extends Venditore {

    private Pacchetto pacchetto = null;
    private String processoDistribuzione;
    private final HandlerProdotto pacchettoHandler;

    public Distributore(String id,
                        String username,
                        String nome,
                        String cognome,
                        String email,
                        String password,
                        String cellNumber,
                        Indirizzo indirizzo) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo);
        this.processoDistribuzione = processoDistribuzione;
        this.pacchettoHandler = new HandlerProdotto(this);
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (this.pacchetto != null && prodotto != null) {
            this.pacchetto.aggiungiProdotto(prodotto);
        } else {
            System.out.println("Errore: nessun pacchetto in corso oppure subProduct nullo.");
        }
    }

    public Prodotto assiemeFinito() {
        if (this.pacchetto == null) {
            System.out.println("Nessun pacchetto in corso.");
            return null;
        }
        Prodotto assiemefinito = this.pacchetto;
        this.pacchetto = null;
        return assiemefinito;
    }

    @Override
    public Prodotto createProduct(String nome,
                                  String descrizione,
                                  String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
            return pacchettoHandler.creaProdotto(nome, descrizione, certificazioni, indirizzo, id_venditore, prezzo, quantitativo);
        }


    }
}
