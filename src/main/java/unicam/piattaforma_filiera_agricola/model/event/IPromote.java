package unicam.piattaforma_filiera_agricola.model.event;

import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

public interface IPromote {

    public void aggiungiVenditore(Venditore venditore);

    public void rimuoviVenditore(Venditore venditore);

    public void organizzaEvento(Evento evento);

    public void rimuoviEvento(Evento evento);

}