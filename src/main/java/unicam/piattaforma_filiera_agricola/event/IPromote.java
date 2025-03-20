package unicam.piattaforma_filiera_agricola.event;

import unicam.piattaforma_filiera_agricola.seller.Venditore;

import java.util.List;

public interface IPromote {

    public void aggiungiVenditore(Venditore venditore);

    public void rimuoviVenditore(Venditore venditore);

    public void organizzaEvento(Evento evento);

    public void rimuoviEvento(Evento evento);

}