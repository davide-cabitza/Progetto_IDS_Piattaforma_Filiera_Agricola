package unicam.piattaforma_filiera_agricola.curatore;

import unicam.piattaforma_filiera_agricola.event.Evento;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

public interface IValidate {

    public void approvaProdotto(Prodotto p);

    public void approvaEvento(Evento e);

    public void rifiutaProdotto(Prodotto p);

    public void rifiutaEvento(Evento e);
}
