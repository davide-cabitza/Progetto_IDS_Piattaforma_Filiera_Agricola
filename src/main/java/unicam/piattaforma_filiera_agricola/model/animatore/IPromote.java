package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

public interface IPromote {

    public void aggiungiVenditore(Venditore venditore);

    public void rimuoviVenditore(Venditore venditore);

    public void organizzaEvento(Evento evento);

}