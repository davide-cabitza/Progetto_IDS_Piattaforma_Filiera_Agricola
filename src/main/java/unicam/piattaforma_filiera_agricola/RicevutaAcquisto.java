package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

public class RicevutaAcquisto {

    private List<Prodotto> prodotti;
    private double ivaPercentuale = 4.0;
    private double iva;
    private double totale;

    public RicevutaAcquisto(List<Prodotto> prodotti, double totaleSpeso) {
        this.prodotti = prodotti;
        this.iva = calcolaIva(totaleSpeso, ivaPercentuale);
        this.totale = totaleSpeso + iva;
    }

    // Metodo per calcolare l'IVA
    private double calcolaIva(double importo, double ivaPercentuale) {
        return importo * (ivaPercentuale / 100);
    }

    public void getProdotti() {
        for (Prodotto prodotto : prodotti) {
            System.out.println(prodotto.getNomeProdotto());
        }
    }

    public double getIvaPercentuale() {
        return ivaPercentuale;
    }

    public void setIvaPercentuale(double percentuale) {
        this.ivaPercentuale = percentuale;
    }

    public double getTotaleSpeso() {
        return totale;
    }

}
