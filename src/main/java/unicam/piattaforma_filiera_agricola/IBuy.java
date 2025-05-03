package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public interface IBuy {

    public void acquista(Prodotto p, Pacchetto pa);

    public void aggiungiPacchettoAlCarrello(Pacchetto pa);
    public void aggiungiProdottoAlCarrello(Prodotto prodotto);
}
