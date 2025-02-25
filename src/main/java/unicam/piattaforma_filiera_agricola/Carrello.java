package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
    private List<Prodotto> prodotti;
    private Acquirente acquirente;
    private List<PacchettoProdotti> pacchetti;

    public Carrello(Acquirente acquirente) {
        this.acquirente = acquirente;
        this.prodotti = new ArrayList<>();
        this.pacchetti = new ArrayList<>();
    }





}
