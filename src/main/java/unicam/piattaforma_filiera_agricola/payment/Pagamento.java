package unicam.piattaforma_filiera_agricola.payment;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

public class Pagamento {

    private IPaymentMethod metodoPagamento;
    private List<Prodotto> prodotti;
    private double totale;
    private final double iva = 4;
    private double totalePiuIva;
    private RicevutaAcquisto ricevutaAcquisto;

    // Costruttore che riceve il totale da pagare
    public Pagamento(List<Prodotto> prodotti, IPaymentMethod paymentMehtod) {
        this.prodotti = prodotti;
        this.metodoPagamento = paymentMehtod;
        this.totale = calcolaTotale();
        this.totalePiuIva = calcolaTotaleConIva();
    }

    public Double calcolaTotale() {
        double sommaCosti = 0;
        for (Prodotto prodotto : prodotti) {
            sommaCosti = sommaCosti + prodotto.getPrezzo();
        }
        return sommaCosti;
    }

    private double calcolaTotaleConIva() {
        return totale * (iva / 100);
    }

    // Metodo per impostare il tipo di pagamento
    public void scegliMetodoPagamento(IPaymentMethod metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    // Metodo per eseguire il pagamento
    public void eseguiPagamento() {
        if (metodoPagamento != null) {
            metodoPagamento.eseguiPagamento(totale);
        } else {
            System.out.println("Metodo di pagamento non selezionato.");
        }
    }

    // Metodo per generare la ricevuta
    public void generaRicevuta() {
        this.ricevutaAcquisto = new RicevutaAcquisto(prodotti, totalePiuIva);
        eseguiPagamento(); // Esegui il pagamento e stampa il metodo scelto
    }
}