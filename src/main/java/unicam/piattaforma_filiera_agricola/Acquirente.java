package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.handler.HandlerGestioneCarrello;
import unicam.piattaforma_filiera_agricola.product.PacchettoProdotti;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class Acquirente extends UtenteLoggato implements IBuy{

    private List<PacchettoProdotti> pacchettiCarrello;
    private String indirizzoSpedizioni;
    private Carrello carrello;
    private HandlerGestioneCarrello handlerGestioneCarrelloCarrello;



    public Acquirente(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String indirizzoSpedizioni) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente);
        this.indirizzoSpedizioni = indirizzoSpedizioni;
        this.pacchettiCarrello = new ArrayList<>();
        this.carrello= new Carrello();
        this.handlerGestioneCarrelloCarrello = new HandlerGestioneCarrello();
    }


    @Override
    public void acquista(Prodotto p, PacchettoProdotti pa) {
        if (carrello.getProdotti().contains(p)) {
            System.out.println("Acquisto completato: " + p.getNomeProdotto());
            carrello.getProdotti().remove(p);
        } else {
            System.out.println("Il prodotto non è nel carrello.");
        } if (carrello.getPacchetti().contains(pa)){
            System.out.println("Acquisto completato: " + pa.getNomePacchetto());
            carrello.getPacchetti().remove(pa);
        }else {
            System.out.println("Il pacchetto non è nel carrello.");
        }
    }

    @Override
    public void aggiungiProdottoAlCarrello(Prodotto prodotto) {
        handlerGestioneCarrelloCarrello.aggiungiProdottoAlCarrello(this, prodotto);
    }

    public void rimuoviProdottoDalCarrello(Prodotto prodotto) {
        handlerGestioneCarrelloCarrello.rimuoviProdottoDalCarrello(this, prodotto);
    }

    @Override
    public void aggiungiPacchettoAlCarrello(PacchettoProdotti pacchetto) {
        handlerGestioneCarrelloCarrello.aggiungiPacchettoAlCarrello(this, pacchetto);
    }

    public void rimuoviPacchettoDalCarrello(PacchettoProdotti pacchetto) {
        handlerGestioneCarrelloCarrello.rimuoviPacchettoDalCarrello(this, pacchetto);
    }

    public void visualizzaCarrello() {
        System.out.println("Prodotti nel carrello:");

        if (carrello.getProdotti().isEmpty() && carrello.getPacchetti().isEmpty()) {
            System.out.println("Il carrello è vuoto.");
            return;
        }

        for (Prodotto p : carrello.getProdotti()) {
            System.out.println("- " + p.getNomeProdotto() + " | Prezzo: " + p.getCosto() + "€");
        }

        for (PacchettoProdotti pacchetto : carrello.getPacchetti()) {
            System.out.println("- Pacchetto con " + pacchetto.getProdotti().size() + " prodotti | Prezzo: " + pacchetto.getCosto() + "€");

            for (Prodotto p : pacchetto.getProdotti()) {
                System.out.println("  * " + p.getNomeProdotto() + " | Prezzo: " + p.getCosto() + "€");
            }
        }
    }

    public String getIndirizzoSpedizioni() {
        return indirizzoSpedizioni;
    }

    public void setIndirizzoSpedizioni(String indirizzoSpedizioni) {
        this.indirizzoSpedizioni = indirizzoSpedizioni;
    }

    public void svuotaCarrello() {
        carrello.getProdotti().clear();
        carrello.getPacchetti().clear();
    }

    public Carrello getCarrello() { return carrello; }



}
