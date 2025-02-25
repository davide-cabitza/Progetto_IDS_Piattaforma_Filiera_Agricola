package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class Acquirente extends UtenteLoggato implements IBuy{

    private List<Prodotto> carrello;
    private List<PacchettoProdotti> pacchettiCarrello;


    String indirizzoSpedizioni;
    public Acquirente(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String indirizzoSpedizioni) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password);
        this.indirizzoSpedizioni = indirizzoSpedizioni;
        this.carrello = new ArrayList<>();
        this.pacchettiCarrello = new ArrayList<>();
    }

    @Override
    public void addToCart(Prodotto p) {
        carrello.add(p);
        System.out.println("Prodotto aggiunto al carrello: " + p.getNomeProdotto());
    }

    @Override
    public void acquista(Prodotto p) {
        if (carrello.contains(p)) {
            System.out.println("Acquisto completato per il prodotto: " + p.getNomeProdotto());
            carrello.remove(p);
        } else {
            System.out.println("Il prodotto non è nel carrello.");
        }
    }

    public void rimuoviDalCarrello(Prodotto prodotto) {
        carrello.remove(prodotto);
    }

    public void aggiungiPacchettoAlCarrello(PacchettoProdotti pacchetto) {
        pacchettiCarrello.add(pacchetto);
    }

    public void rimuoviPacchettoDalCarrello(PacchettoProdotti pacchetto) {
        pacchettiCarrello.remove(pacchetto);
    }

    public void visualizzaCarrello() {
        System.out.println("Prodotti nel carrello:");
        for (Prodotto p : carrello) {
            System.out.println("- " + p.getNomeProdotto() + " | Prezzo: " + p.getCosto() + "€");
        }
    }

    public String getIndirizzoSpedizioni() {
        return indirizzoSpedizioni;
    }

    public void setIndirizzoSpedizioni(String indirizzoSpedizioni) {
        this.indirizzoSpedizioni = indirizzoSpedizioni;
    }

    public void svuotaCarrello() {
        carrello.clear();
        pacchettiCarrello.clear();
    }

    public void confermaAcquisto() {
        if (carrello.isEmpty() && pacchettiCarrello.isEmpty()) {
            System.out.println("Il carrello è vuoto. Aggiungi prodotti prima di acquistare.");
            return;
        }

        System.out.println("Acquisto confermato! Grazie per aver acquistato.");
        svuotaCarrello();
    }

}
