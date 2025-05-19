package unicam.piattaforma_filiera_agricola.model.buyer;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carrello {
    private final List<Prodotto> prodotti = new ArrayList<>();

    public Carrello() {}
    public List<Prodotto> getRighe() { return prodotti; }
    public void aggiungiProdotto(Prodotto prodotto) { if(prodotto != null) prodotti.add(prodotto); }
    public void rimuoviPrdotto(Long id) { prodotti.removeIf(prodotto -> prodotto.getId() == id);}
    public void svuota() { this.prodotti.clear(); }
    public double calcolaTotale() {
        return prodotti.stream()
                .mapToDouble(Prodotto::getCosto)
                .sum();
    }
}