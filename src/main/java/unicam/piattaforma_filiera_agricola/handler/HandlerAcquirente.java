package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.buyer.Acquirente;
import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;
import unicam.piattaforma_filiera_agricola.model.payment.Pagamento;
import unicam.piattaforma_filiera_agricola.model.payment.Ricevuta;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.repository.ProdottoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Service per la gestione dell'acquirente e delle operazioni relative al carrello e ai pagamenti.
 */
@Service
public class HandlerAcquirente {

    private Carrello shoppingCart;
    private List<Pagamento> payments;
    private final ProdottoRepository prodottoRepository;

    /**
     * Costruttore per inizializzare il repository dei prodotti e il carrello.
     *
     * @param prodottoRepository repository per accedere ai prodotti disponibili.
     */
    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.shoppingCart = new Carrello();
        this.payments = new ArrayList<>();
    }

    /**
     * Aggiunge un prodotto al carrello dell'acquirente.
     *
     * @param productId ID del prodotto da aggiungere.
     * @throws RuntimeException se il prodotto con l'ID specificato non esiste.
     */
    public void addProduct(Long productId) {
        Prodotto product = prodottoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + productId));
        this.shoppingCart.aggiungiProdotto(product);
    }

    /**
     * Rimuove un prodotto dal carrello dell'acquirente.
     *
     * @param productId ID del prodotto da rimuovere.
     */
    public void removeProduct(Long productId) {
        this.shoppingCart.rimuoviPrdotto(productId);
    }

    /**
     * Esegue il pagamento del carrello, genera una ricevuta, salva il pagamento e svuota il carrello.
     *
     * @param acquirente L'acquirente che effettua il pagamento.
     * @return L'oggetto Pagamento generato.
     */
    public Pagamento pay(Acquirente acquirente) {
        String invoiceContent = generateInvoice(this.shoppingCart);
        Ricevuta invoice = new Ricevuta(invoiceContent);
        Pagamento pagamento = new Pagamento(acquirente, this.shoppingCart, invoice);
        this.payments.add(pagamento);
        this.shoppingCart.svuota();
        return pagamento;
    }

    /**
     * Genera il contenuto della ricevuta basandosi sui prodotti presenti nel carrello.
     *
     * @param cart Il carrello dell'acquirente.
     * @return Il contenuto testuale della ricevuta.
     */
    private String generateInvoice(Carrello cart) {
        double total = 0;
        StringBuilder sb = new StringBuilder("Ricevuta:\n");
        for (Prodotto p : cart.getRighe()) {
            sb.append("Prodotto: ").append(p.getNomeProdotto())
                    .append(" - Prezzo: ").append(p.getCosto()).append("\n");
            total += p.getCosto();
        }
        sb.append("Totale: ").append(total);
        return sb.toString();
    }

    /**
     * Restituisce il carrello dell'acquirente.
     *
     * @return L'oggetto Carrello contenente i prodotti selezionati.
     */
    public Carrello getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Restituisce la lista dei pagamenti effettuati.
     *
     * @return Lista di oggetti Pagamento.
     */
    public List<Pagamento> getPayments() {
        return payments;
    }
}
