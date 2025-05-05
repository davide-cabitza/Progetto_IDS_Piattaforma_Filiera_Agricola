package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;
import unicam.piattaforma_filiera_agricola.model.buyer.RigaCarrello;
import unicam.piattaforma_filiera_agricola.model.buyer.Ordine;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HandlerCarrello {
    private final Carrello carrello;
    public HandlerCarrello(Carrello c) { this.carrello = c; }
    public void aggiungiProdotto(Prodotto p, int q) {
        for (RigaCarrello r : carrello.getRighe()) {
            if (r.getProdotto().equals(p)) { r.setQuantita(r.getQuantita()+q); return; }
        }
        carrello.addRiga(new RigaCarrello(p,q));
    }
    public void rimuoviProdotto(Prodotto p) {
        carrello.getRighe().stream()
                .filter(r->r.getProdotto().equals(p)).findFirst()
                .ifPresent(r->carrello.removeRiga(r));
    }
    public List<RigaCarrello> getContenuto() { return new ArrayList<>(carrello.getRighe()); }
    public void svuotaCarrello() { carrello.svuota(); }
}