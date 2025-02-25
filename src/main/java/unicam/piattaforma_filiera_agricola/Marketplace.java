package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    String stato;
    Prodotto[] prodotto;

    public Marketplace(Prodotto[] prodotto, String stato) {
        this.stato = stato;
        this.prodotto = prodotto;
    }

    public Prodotto[] cercaProdotto(String prod) {
        List<Prodotto> risultati = new ArrayList<>();

        for (Prodotto p : prodotto) {
            if (p.getNomeProdotto().equalsIgnoreCase(prod)) { // Confronto case-insensitive
                risultati.add(p);
            }
        }

        return risultati.toArray(new Prodotto[0]);
    }
}
