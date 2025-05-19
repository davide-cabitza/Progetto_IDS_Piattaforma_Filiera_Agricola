package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class HandlerCarrello {
    private final Carrello carrello;

    public HandlerCarrello(Carrello c) { this.carrello = c; }

    public void aggiungiProdotto(Prodotto p) {
        for (Prodotto pr : carrello.getProdotti()) {
            if (pr.equals(p)) {pr.setQuantita(pr.getQuantita() + p.getQuantita()); return; }
        }
        carrello.aggiungiProdotto(p);
    }

    public void rimuoviProdotto(Prodotto p) {
        if (carrello.getProdotti().contains(p)) {carrello.rimuoviPrdotto(p.getId());}
    }

    public List<Prodotto> getContenuto() { return new ArrayList<>(carrello.getProdotti()); }

    public void svuotaCarrello() { carrello.svuota(); }
}