package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.handler.HandlerGestioneCarrello;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

public class Acquirente extends UtenteLoggato{

    private final HandlerGestioneCarrello carrelloHandler;
    private final OrdineHandler ordineHandler;

    public Acquirente(String id, String nome, String cognome, String email) {
        super(id, nome, cognome, email, Ruolo.ACQUIRENTE);
        this.carrelloHandler = new HandlerGestioneCarrello(new Carrello(this));
        this.ordineHandler = new OrdineHandler(this.carrelloHandler.getCarrello());
    }

    // Getter per il handler del carrello
    public HandlerGestioneCarrello getCarrelloHandler() {
        return carrelloHandler;
    }

    // Metodi relativi al carrello delegati al handler
    public void aggiungiAlCarrello(Prodotto prodotto, int quantita) {
        carrelloHandler.aggiungiProdotto(prodotto, quantita);
    }

    public void rimuoviDalCarrello(Prodotto prodotto) {
        carrelloHandler.rimuoviProdotto(prodotto);
    }

    // Metodo per visualizzare il contenuto del carrello
    public List<RigaCarrello> visualizzaCarrello() {
        return carrelloHandler.getContenutoCarrello();
    }

    // Metodo di ricerca prodotti
    public List<Prodotto> cercaProdotti(String query) {
        return ServizioProdotti.findByName(query);
    }

    // Metodo per acquistare i prodotti nel carrello
    public Ordine acquistaProdotti() {
        Ordine ordine = ordineHandler.creaOrdine();
        ordineHandler.processaPagamento(ordine);
        ordineHandler.confermaOrdine(ordine);
        carrelloHandler.svuotaCarrello();
        return ordine;
    }

}
