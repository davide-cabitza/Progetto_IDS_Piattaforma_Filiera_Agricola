package unicam.piattaforma_filiera_agricola.model.payment;
import  unicam.piattaforma_filiera_agricola.model.buyer.Acquirente;
import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;

/**
 * Rappresenta un pagamento: associa un acquirente,
 * lo snapshot del carrello e la relativa ricevuta.
 */
public class Pagamento {

    private final Acquirente payer;
    private final Carrello productsSnapshot;
    private final Ricevuta invoice;

    /**
     * Costruisce un pagamento completo.
     *
     * @param payer           l'acquirente che effettua il pagamento
     * @param productsSnapshot snapshot del carrello con i prodotti acquistati
     * @param invoice         la ricevuta generata
     */
    public Pagamento(Acquirente payer, Carrello productsSnapshot, Ricevuta invoice) {
        this.payer = payer;
        this.productsSnapshot = productsSnapshot;
        this.invoice = invoice;
    }

    /**
     * L'acquirente che ha pagato.
     */
    public Acquirente getPayer() {
        return payer;
    }

    /**
     * Snapshot del carrello al momento del pagamento.
     */
    public Carrello getProductsSnapshot() {
        return productsSnapshot;
    }

    /**
     * La ricevuta generata dal pagamento.
     */
    public Ricevuta getInvoice() {
        return invoice;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "payer=" + payer +
                ", productsSnapshot=" + productsSnapshot +
                ", invoice=" + invoice +
                '}';
    }
}