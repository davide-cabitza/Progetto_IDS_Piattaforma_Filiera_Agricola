package unicam.piattaforma_filiera_agricola.model;

import unicam.piattaforma_filiera_agricola.model.product.PacchettoProdotti;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public interface IBuy {

    public void acquista(Prodotto p, PacchettoProdotti pa);

    public void aggiungiPacchettoAlCarrello(PacchettoProdotti pa);
    public void aggiungiProdottoAlCarrello(Prodotto prodotto);
}
