package unicam.piattaforma_filiera_agricola.model.buyer;

import unicam.piattaforma_filiera_agricola.handler.HandlerCarrello;
import unicam.piattaforma_filiera_agricola.handler.HandlerOrdine;
import unicam.piattaforma_filiera_agricola.service.OSMService;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.buyer.Ordine;
import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;

import java.util.List;

/**
 * Rappresenta un Acquirente che può cercare prodotti, gestire il carrello,
 * acquistare, utilizzare servizi esterni (OSM) ed eliminare il profilo.
 */
public class Acquirente extends UtenteLoggato {

    private final Carrello carrello;
    private final HandlerCarrello carrelloHandler;
    private final HandlerOrdine ordineHandler;
    private final OSMService osmService;

    public Acquirente(String id,
                      String nome,
                      String cognome,
                      String email) {
        super(id, nome, cognome, email, Ruolo.ACQUIRENTE);
        this.carrello = new Carrello(this);
        this.carrelloHandler = new HandlerCarrello(carrello);
        this.ordineHandler = new HandlerOrdine();
        this.osmService = new OSMService();
    }

    /** Cerca prodotti in base al nome. */
    public List<Prodotto> cercaProdotti(String query) {
        return ProdottoService.search(query);
    }

    /** Aggiunge un prodotto al carrello con la quantità specificata. */
    public void aggiungiAlCarrello(Prodotto prodotto, int quantita) {
        carrelloHandler.aggiungiProdotto(prodotto, quantita);
    }

    /** Rimuove un prodotto dal carrello. */
    public void rimuoviDalCarrello(Prodotto prodotto) {
        carrelloHandler.rimuoviProdotto(prodotto);
    }

    /** Restituisce il contenuto attuale del carrello. */
    public List<RigaCarrello> visualizzaCarrello() {
        return carrelloHandler.getContenuto();
    }

    /** Effettua l'acquisto dei prodotti presenti nel carrello. */
    public Ordine acquistaProdotti() {
        var righe = carrelloHandler.getContenuto();
        Ordine ordine = ordineHandler.creaOrdine(righe);
        ordineHandler.processaPagamento(ordine);
        ordineHandler.confermaOrdine(ordine);
        carrelloHandler.svuotaCarrello();
        return ordine;
    }

    /** Ottiene l'URL della mappa basata sull'indirizzo. */
    public String visualizzaMappa(String indirizzo) {
        return osmService.getMappaUrl(indirizzo);
    }

    /** Elimina il profilo, svuota carrello e annulla ordini pendenti. */
    public void eliminaProfilo() {
        carrelloHandler.svuotaCarrello();
        ordineHandler.annullaOrdiniPendenti(acquistaProdotti().getIdOrdine());
        AccountService.deleteAccount(getId());
    }
}
