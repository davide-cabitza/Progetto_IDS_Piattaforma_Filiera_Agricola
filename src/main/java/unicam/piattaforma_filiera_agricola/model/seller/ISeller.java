package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public interface ISeller {

    public void caricaProdotto(Prodotto p);

    public void modificaProdotto(Prodotto p);

}
