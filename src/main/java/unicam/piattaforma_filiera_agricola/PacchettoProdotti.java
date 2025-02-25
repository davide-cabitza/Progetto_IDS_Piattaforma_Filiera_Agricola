package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class PacchettoProdotti extends Prodotto{


    private List<Prodotto> listaProdotti;
    private float prezzoBase;

    // Costruttore
    public PacchettoProdotti(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, String categoria, int id_venditore, long dataInserimento, List<Prodotto> prodotti) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, categoria, id_venditore, dataInserimento);
        this.listaProdotti = prodotti;
        this.prezzoBase = prezzoBase;
    }

    // Metodo per aggiungere un prodotto al pacchetto
    public void aggiungiProdotto(Prodotto prodotto) {
        listaProdotti.add(prodotto);
    }

    // Metodo per rimuovere un prodotto dal pacchetto
    public void rimuoviProdotto(Prodotto prodotto) {
        listaProdotti.remove(prodotto);
    }

    // Metodo per calcolare il prezzo totale del pacchetto
    public float calcolaPrezzoTotale() {
        float totale = prezzoBase;
        for (Prodotto p : listaProdotti) {
            totale += p.getCosto();
        }
        return totale;
    }

    // Getter

    public List<Prodotto> getProdotti() {
        return listaProdotti;
    }

    public float getPrezzoBase() {
        return prezzoBase;
    }

    // Setter
    public void setPrezzoBase(float prezzoBase) {
        this.prezzoBase = prezzoBase;
    }
}
