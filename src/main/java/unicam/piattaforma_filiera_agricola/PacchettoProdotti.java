package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PacchettoProdotti extends Prodotto{


    private List<Prodotto> listaProdotti;
    private String nomePacchetto;


    // Costruttore
    public PacchettoProdotti(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, String categoria, int id_venditore, Date dataInserimento, List<Prodotto> prodotti,String nomePacchetto) {
        super(id, nomeProdotto, descrizione, certificati, costo, quantitativo, categoria, id_venditore, dataInserimento);
        this.listaProdotti = prodotti;
        this.nomePacchetto=nomePacchetto;
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
        float totale = 0;
        for (Prodotto p : listaProdotti) {
            totale += p.getCosto();
        }
        return totale;
    }

    // Getter

    public List<Prodotto> getProdotti() {
        return listaProdotti;
    }

    public String getNomePacchetto() {
         return nomePacchetto;
    }
}
