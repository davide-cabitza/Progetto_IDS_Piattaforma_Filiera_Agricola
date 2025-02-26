package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.product.PacchettoProdotti;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

public interface IBuy {

    public void acquista(Prodotto p, PacchettoProdotti pa);

    public void aggiungiPacchettoAlCarrello(PacchettoProdotti pa);
    public void aggiungiProdottoAlCarrello(Prodotto prodotto);
}
