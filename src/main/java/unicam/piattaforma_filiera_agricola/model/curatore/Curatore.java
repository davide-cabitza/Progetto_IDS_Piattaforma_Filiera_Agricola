package unicam.piattaforma_filiera_agricola.model.curatore;

import unicam.piattaforma_filiera_agricola.model.event.Evento;
import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.handler.HandlerPubblicazione;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Curatore extends UtenteLoggato implements IValidate {

    private List<Prodotto> listaProdottiVerificati;
    private static List<Evento> marketplaceEventi = new ArrayList<>(); // Lista globale eventi approvati
    private HandlerPubblicazione handlerPubblicazione;


    public Curatore(int id, String nome, String email, String password, int numeroTelefono, String indirizzo, String NomeUtente) {
        super(id, nome, email, password, numeroTelefono, indirizzo, NomeUtente);
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
    public void approvaProdotto(Prodotto p) {
        handlerPubblicazione.approvaProdotto(p);

    }

    @Override
    public void rifiutaProdotto(Prodotto p, String nota) {
        handlerPubblicazione.rifiutaProdotto(p, nota);

    }

}
