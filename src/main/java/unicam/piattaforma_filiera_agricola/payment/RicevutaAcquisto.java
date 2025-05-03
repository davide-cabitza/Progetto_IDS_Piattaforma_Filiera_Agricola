package unicam.piattaforma_filiera_agricola.payment;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

public class RicevutaAcquisto {

    private List<Prodotto> prodotti;
    private double totale;

    public RicevutaAcquisto(List<Prodotto> prodotti, double totaleSpeso) {
        this.prodotti = prodotti;
        this.totale = totaleSpeso;
    }

    public void getProdotti() {
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto.getNomeProdotto());
        }
    }

    public double getTotaleSpeso() {
        return totale;
    }

}
