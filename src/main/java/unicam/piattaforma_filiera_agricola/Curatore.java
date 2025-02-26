package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class Curatore extends UtenteLoggato implements IValidate{


    private List<Prodotto> listaProdottiVerificati;
    private static List<Evento> marketplaceEventi = new ArrayList<>(); // Lista globale eventi approvati
    private HandlerPubblicazione handlerPubblicazione;


    public Curatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente);
        this.listaProdottiVerificati = new ArrayList<>();
    }




    public List<Prodotto> getProdottiVerificati() {
        return listaProdottiVerificati;
    }

    // Metodo per recuperare la lista di eventi disponibili
    public static List<Evento> getMarketplaceEventi() {
        return marketplaceEventi;
    }


    @Override
    public void approvaPubblicazioneProdotto(Prodotto p) {
        handlerPubblicazione.approvaPubblicazioneProdotto(p);

    }

    @Override
    public void approvaPubblicazioneEvento(Evento e) {
        handlerPubblicazione.approvaPubblicazioneEvento(e);
    }

    @Override
    public void rifiutaPubblicazioneProdotto(Prodotto p) {
        handlerPubblicazione.approvaPubblicazioneProdotto(p);

    }

    @Override
    public void rifiutaPubblicazioneEvento(Evento e) {
        handlerPubblicazione.rifiutaPubblicazioneEvento(e);
    }
}
