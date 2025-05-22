package unicam.piattaforma_filiera_agricola.model.buyer;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
public class Carrello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Prodotto> prodotti = new ArrayList<>();

    public Carrello() {}

    public List<Prodotto> getProdotti() { return prodotti; }


    public void aggiungiProdotto(Prodotto prodotti) {
        if (prodotti != null) {
            this.prodotti.add(prodotti);
        }
    }

    public void rimuoviProdotto(Long id) {
        prodotti.removeIf(prodotti -> prodotti.getId().intValue() == id);
    }

    public void svuota() { this.prodotti.clear(); }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

}