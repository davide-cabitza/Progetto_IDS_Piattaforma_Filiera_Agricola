package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.Acquirente;
import unicam.piattaforma_filiera_agricola.Carrello;
import unicam.piattaforma_filiera_agricola.RigaCarrello;
import unicam.piattaforma_filiera_agricola.StatoProdottoCarrello;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;
import java.util.stream.Collectors;

public class HandlerGestioneCarrello {


    private final Carrello carrello;

    public HandlerGestioneCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void aggiungiProdotto(Prodotto prodotto, int quantita) {
        RigaCarrello esistente = carrello.getRighe().stream()
                .filter(r -> r.getProdotto().equals(prodotto) && r.getStato() == StatoProdottoCarrello.ATTIVO)
                .findFirst()
                .orElse(null);
        if (esistente != null) {
            esistente.setQuantita(esistente.getQuantita() + quantita);
        } else {
            carrello.addRiga(new RigaCarrello(prodotto, quantita));
        }
    }

    public void rimuoviProdotto(Prodotto prodotto) {
        carrello.getRighe().stream()
                .filter(r -> r.getProdotto().equals(prodotto) && r.getStato() == StatoProdottoCarrello.ATTIVO)
                .findFirst()
                .ifPresent(r -> {
                    r.marcaRimosso();
                    carrello.removeRiga(r);
                });
    }

    public List<RigaCarrello> getContenutoCarrello() {
        return carrello.getRighe().stream()
                .filter(r -> r.getStato() == StatoProdottoCarrello.ATTIVO)
                .collect(Collectors.toList());
    }

    public void svuotaCarrello() {
        carrello.svuota();
    }
}
