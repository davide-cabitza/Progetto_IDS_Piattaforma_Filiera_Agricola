package unicam.piattaforma_filiera_agricola.seller;

import unicam.piattaforma_filiera_agricola.product.Prodotto;

public interface ISeller {

    public void caricaProdotto(Prodotto p);

    public void modifyProdotto(Prodotto p);

}
