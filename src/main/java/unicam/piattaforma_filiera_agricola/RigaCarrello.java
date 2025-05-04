package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public class RigaCarrello {
    private final Prodotto prodotto;
    private int quantita;
    private StatoProdottoCarrello stato;

    public RigaCarrello(Prodotto prodotto, int quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.stato = StatoProdottoCarrello.ATTIVO;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public StatoProdottoCarrello getStato() {
        return stato;
    }

    void setQuantita(int q) {
        this.quantita = q;
    }

    void marcaRimosso() {
        this.stato = StatoProdottoCarrello.RIMOSSO;
    }
}
