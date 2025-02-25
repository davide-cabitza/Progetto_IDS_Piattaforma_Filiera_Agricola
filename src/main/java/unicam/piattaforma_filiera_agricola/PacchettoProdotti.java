package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class PacchettoProdotti {


    private String nome;
    private List<Prodotto> prodotti;
    private float prezzoBase;

    // Costruttore
    public PacchettoProdotti(String nome, float prezzoBase) {
        this.nome = nome;
        this.prezzoBase = prezzoBase;
        this.prodotti = new ArrayList<>();
    }

    // Metodo per aggiungere un prodotto al pacchetto
    public void aggiungiProdotto(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    // Metodo per rimuovere un prodotto dal pacchetto
    public void rimuoviProdotto(Prodotto prodotto) {
        prodotti.remove(prodotto);
    }

    // Metodo per calcolare il prezzo totale del pacchetto
    public float calcolaPrezzoTotale() {
        float totale = prezzoBase;
        for (Prodotto p : prodotti) {
            totale += p.getCosto();
        }
        return totale;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public float getPrezzoBase() {
        return prezzoBase;
    }

    // Setter
    public void setPrezzoBase(float prezzoBase) {
        this.prezzoBase = prezzoBase;
    }
}
