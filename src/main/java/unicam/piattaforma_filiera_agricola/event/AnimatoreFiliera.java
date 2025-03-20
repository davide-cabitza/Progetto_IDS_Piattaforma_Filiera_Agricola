package unicam.piattaforma_filiera_agricola.event;

import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.seller.Venditore;

import java.util.ArrayList;
import java.util.List;

public class AnimatoreFiliera extends UtenteLoggato implements IPromote{

    private List<Venditore> venditoriGestiti;
    private List<Evento> eventiOrganizzati;

    
    public AnimatoreFiliera(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente);
        this.venditoriGestiti = new ArrayList<>();
        this.eventiOrganizzati = new ArrayList<>();

    }


    @Override
    public void aggiungiVenditore(Venditore venditore) {
        venditoriGestiti.add(venditore);
        System.out.println("Venditore " + venditore.getNome() + " aggiunto alla gestione.");
    }


    @Override
    public void rimuoviVenditore(Venditore venditore) {
        venditoriGestiti.remove(venditore);
        System.out.println("Venditore " + venditore.getNome() + " rimosso dalla gestione.");
    }


    @Override
    public void organizzaEvento(Evento evento) {
        eventiOrganizzati.add(evento);
        System.out.println("Evento \"" + evento.getNomeEvento() + "\" organizzato con successo.");
    }


    @Override
    public void rimuoviEvento(Evento evento) {
        eventiOrganizzati.remove(evento);
        System.out.println("Evento \"" + evento.getNomeEvento() + "\" rimosso.");
    }


    public void visualizzaEventi() {
        System.out.println("Eventi organizzati:");
        for (Evento evento : eventiOrganizzati) {
            System.out.println("- " + evento.getNomeEvento() + " | Data: " + evento.getData());
        }
    }


    public List<Evento> getEventiOrganizzati() {
        return eventiOrganizzati;
    }

    public List<Venditore> getVenditoriGestiti() {
        return venditoriGestiti;
    }

}
