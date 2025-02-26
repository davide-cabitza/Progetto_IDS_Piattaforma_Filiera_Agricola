package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.product.PacchettoProdotti;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti;
    private List<PacchettoProdotti> pacchetti;

    public Carrello() {
        this.prodotti = new ArrayList<>();
        this.pacchetti = new ArrayList<>();
    }
    public List<Prodotto> getProdotti() { return prodotti; }
    public List<PacchettoProdotti> getPacchetti() { return pacchetti; }

    public void aggiungiProdotto(Prodotto prodotto) { prodotti.add(prodotto); }
    public void rimuoviProdotto(Prodotto prodotto) { prodotti.remove(prodotto); }

    public void aggiungiPacchetto(PacchettoProdotti pacchetto) { pacchetti.add(pacchetto); }
    public void rimuoviPacchetto(PacchettoProdotti pacchetto) { pacchetti.remove(pacchetto); }

    public void svuotaCarrello() {
        prodotti.clear();
        pacchetti.clear();
    }

    public double calcolaImporto() {
        double totale = 0.0;
        for (Prodotto p : prodotti) { totale += p.getCosto(); }
        for (PacchettoProdotti pacchetto : pacchetti) { totale += pacchetto.getCosto(); }
        return totale;
    }



}
