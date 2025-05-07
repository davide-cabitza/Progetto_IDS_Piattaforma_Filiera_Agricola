package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.handler.HandlerPacchetto;
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
    private final HandlerPacchetto pacchettoHandler;

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
        this.pacchettoHandler = new HandlerPacchetto(this);
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
                                 double prezzo,
                                 List<String> certificazioni) {
        return super.creaProdotto(nome, descrizione, prezzo, certificazioni);
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
