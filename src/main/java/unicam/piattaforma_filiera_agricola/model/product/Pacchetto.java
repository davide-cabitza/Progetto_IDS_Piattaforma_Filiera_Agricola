package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.model.seller.Distributore;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacchetto extends Prodotto {

    private List<Prodotto> pacchetto;

    public Pacchetto(String id, String nome, String descrizione, String certificazioni, Indirizzo indirizzo, int id_venditore, List<Prodotto> pacchetto, double costo, int quantita)
    {
        super(id, nome, descrizione, certificazioni, indirizzo, id_venditore, costo, quantita);
        if (pacchetto == null) {
            this.pacchetto = new ArrayList<>();
        } else {
            this.pacchetto = pacchetto;
        }
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (prodotto != null) {
            this.pacchetto.add(prodotto);
        }
    }
    public List<Prodotto> getPacchetto() {return this.pacchetto;}

    public void setPacchetto(List<Prodotto> pacchetto) {this.pacchetto = pacchetto;}
}
