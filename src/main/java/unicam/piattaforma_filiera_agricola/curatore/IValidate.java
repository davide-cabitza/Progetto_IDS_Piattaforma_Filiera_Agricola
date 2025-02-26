package unicam.piattaforma_filiera_agricola.curatore;

import unicam.piattaforma_filiera_agricola.event.Evento;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

public interface IValidate {

    public void approvaPubblicazioneProdotto(Prodotto p);

    public void approvaPubblicazioneEvento(Evento e);

    public void rifiutaPubblicazioneProdotto(Prodotto p);

    public void rifiutaPubblicazioneEvento(Evento e);
}
