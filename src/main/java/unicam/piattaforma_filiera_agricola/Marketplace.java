package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    List<Prodotto> listaProdotti;
    boolean stato;

    public Marketplace(List<Prodotto> prodotti, boolean state) {
        this.listaProdotti = prodotti;
        this.stato = state;
    }
    /*
    public Prodotto cercaProdotto(String prod) {
        List<Prodotto> risultati = new ArrayList<>();
        for (Prodotto p : this.listaProdotti) {
            if (p.getNomeProdotto().equalsIgnoreCase(prod)) {
                risultati.add(p);
            }
        }
        return risultati.getFirst();

    }
    */


    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    private void setListaProdotti(List<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public boolean isStato() {
        return stato;
    }

    private void setStato(boolean stato) {
        this.stato = stato;
    }
}
