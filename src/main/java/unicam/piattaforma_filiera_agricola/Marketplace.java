package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {

    List<Prodotto> listaProdotti;

    public Marketplace(List<Prodotto> prodotti) {
    }

    public List<Prodotto> cercaProdotto(String prod) {
        List<Prodotto> risultati = new ArrayList<>();
        for (Prodotto p : this.listaProdotti) {
            if (p.getNomeProdotto().equalsIgnoreCase(prod)) {
                risultati.add(p);
            }
        }
        return risultati;

    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

}
