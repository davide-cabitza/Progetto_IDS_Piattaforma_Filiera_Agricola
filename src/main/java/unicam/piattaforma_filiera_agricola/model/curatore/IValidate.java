package unicam.piattaforma_filiera_agricola.model.curatore;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public interface IValidate {

    public void approvaProdotto(Prodotto p);

    public void rifiutaProdotto(Prodotto p, String nota);

}
