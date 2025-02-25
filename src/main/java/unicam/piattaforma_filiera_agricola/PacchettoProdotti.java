package unicam.piattaforma_filiera_agricola;

public class PacchettoProdotti {
    Prodotto[] listaProdotti;
    float prezzo;

    public PacchettoProdotti(Prodotto[] listaProdotti, float prezzo) {
        this.listaProdotti = listaProdotti;
        this.prezzo = prezzo;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Prodotto[] getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(Prodotto[] listaProdotti) {
        this.listaProdotti = listaProdotti;
    }
}
