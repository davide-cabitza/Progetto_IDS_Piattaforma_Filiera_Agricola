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

    @Autowired
    public HandlerAcquirente(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.shoppingCart = new Carrello();
        this.payments = new ArrayList<>();
    }

    public void addProduct(Long productId) {
        Prodotto product = prodottoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + productId));
        this.shoppingCart.aggiungiProdotto(product);
    }

    public void removeProduct(Long productId) {
        this.shoppingCart.rimuoviProdotto(productId);
    }

    public Pagamento pay(Acquirente acquirente) {
        String invoiceContent = generateInvoice(this.shoppingCart);
        Ricevuta invoice = new Ricevuta(invoiceContent);
        Pagamento pagamento = new Pagamento(acquirente, this.shoppingCart, invoice);
        this.payments.add(pagamento);
        this.shoppingCart.svuota();
        return pagamento;
    }

    private String generateInvoice(Carrello cart) {
        double total = 0;
        StringBuilder sb = new StringBuilder("Ricevuta:\n");
        for (Prodotto p : cart.getProdotti()) {
            sb.append("Prodotto: ").append(p.getNomeProdotto())
                    .append(" - Prezzo: ").append(p.getCosto()).append("\n");
            total += p.getCosto();
        }
        sb.append("Totale: ").append(total);
        return sb.toString();
    }

    public Carrello getShoppingCart() {
        return shoppingCart;
    }

    public List<Pagamento> getPayments() {
        return payments;
    }
}
