package unicam.piattaforma_filiera_agricola.model.product;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.seller.Distributore;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@DiscriminatorValue("PACCHETTO")
public class Pacchetto extends Prodotto {

    @ManyToMany
    @JoinTable(
            name = "pacchetto_prodotti",
            joinColumns = @JoinColumn(name = "pacchetto_id"),
            inverseJoinColumns = @JoinColumn(name = "prodotto_id")
    )
    private List<Prodotto> pacchetto;

    public Pacchetto(String nome, double costo, String descrizione, Indirizzo indirizzo, Venditore venditore, List<Prodotto> pacchetto)
    {
        super(nome, costo, descrizione, indirizzo, venditore);
        if (pacchetto == null) {
            this.pacchetto = new ArrayList<>();
        } else {
            this.pacchetto = pacchetto;
        }
    }

    public Pacchetto() {

    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (prodotto != null) {
            this.pacchetto.add(prodotto);
        }
    }
    public List<Prodotto> getPacchetto() {return this.pacchetto;}

    public void setPacchetto(List<Prodotto> pacchetto) {this.pacchetto = pacchetto;}
}
