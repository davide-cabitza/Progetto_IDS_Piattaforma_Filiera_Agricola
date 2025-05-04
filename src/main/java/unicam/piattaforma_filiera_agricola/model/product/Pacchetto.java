package unicam.piattaforma_filiera_agricola.model.product;

import unicam.piattaforma_filiera_agricola.model.seller.Distributore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pacchetto {

    private final String idPacchetto;
    private String nome;
    private final List<Prodotto> prodotti;
    private double prezzoTotale;
    private final Distributore creatore;

    public Pacchetto(String idPacchetto,
                     String nome,
                     List<Prodotto> prodotti,
                     double prezzoTotale,
                     Distributore creatore) {
        this.idPacchetto = idPacchetto;
        this.nome = nome;
        this.prodotti = new ArrayList<>(prodotti);
        this.prezzoTotale = prezzoTotale;
        this.creatore = creatore;
    }

    public String getIdPacchetto() {
        return idPacchetto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Prodotto> getProdotti() {
        return Collections.unmodifiableList(prodotti);
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Distributore getCreatore() {
        return creatore;
    }
}
