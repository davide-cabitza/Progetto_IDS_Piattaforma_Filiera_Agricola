package unicam.piattaforma_filiera_agricola;

public interface IValidate {

    public void approvaPubblicazioneProdotto(Prodotto p);

    public void approvaPubblicazioneEvento(Evento e);

    public void rifiutaPubblicazioneProdotto(Prodotto p);

    public void rifiutaPubblicazioneEvento(Evento e);
}
