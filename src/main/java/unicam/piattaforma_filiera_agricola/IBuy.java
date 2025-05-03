package unicam.piattaforma_filiera_agricola;

public interface IBuy {

    public void acquista(Prodotto p,PacchettoProdotti pa);

    public void aggiungiPacchettoAlCarrello(PacchettoProdotti pa);
    public void aggiungiProdottoAlCarrello(Prodotto prodotto);
}
