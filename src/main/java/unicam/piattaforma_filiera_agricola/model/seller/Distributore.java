package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.Indirizzo;
import unicam.piattaforma_filiera_agricola.handler.HandlerProdotto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import java.util.List;

/**
 * Rappresenta un Distributore (specializzazione di Venditore)
 * che gestisce un processo di distribuzione dei prodotti
 * e può creare pacchetti di prodotti.
 */
public class Distributore extends Venditore {

    private String processoDistribuzione;
    private final HandlerProdotto pacchettoHandler;

    public Distributore(String id,
                        String username,
                        String nome,
                        String cognome,
                        String email,
                        String password,
                        String cellNumber,
                        String indirizzo,
                        String processoDistribuzione) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo);
        this.processoDistribuzione = processoDistribuzione;
        this.pacchettoHandler = new HandlerProdotto(this);
    }

    public String getProcessoDistribuzione() {
        return processoDistribuzione;
    }

    public void setProcessoDistribuzione(String processoDistribuzione) {
        this.processoDistribuzione = processoDistribuzione;
    }

    /**
     * Crea e pubblica un nuovo prodotto delegando a Venditore.
     */
    @Override
    public Prodotto creaProdotto(String nome,
                                 String descrizione,
                                 String certificazioni, double prezzo, int quantitativo, int id_venditore, Indirizzo indirizzo) {
        return super.creaProdotto(nome, descrizione, certificazioni, prezzo, quantitativo, id_venditore, indirizzo);
    }

    /**
     * Elimina un prodotto delegando a Venditore.
     */
    @Override
    public void eliminaProdotto(Prodotto prodotto) {
        super.eliminaProdotto(prodotto);
    }

    /**
     * Elimina il profilo e rimuove tutti i prodotti.
     */
    @Override
    public void eliminaProfilo() {
        super.eliminaProfilo();
    }

    /**
     * Crea un pacchetto di prodotti delegando a HandlerPacchetto.
     */
    public Pacchetto creaPacchetto(String nome,
                                   List<Prodotto> prodotti,
                                   double prezzoTotale) {
        return pacchettoHandler.creaPacchetto(nome, prodotti, prezzoTotale);
    }
}
