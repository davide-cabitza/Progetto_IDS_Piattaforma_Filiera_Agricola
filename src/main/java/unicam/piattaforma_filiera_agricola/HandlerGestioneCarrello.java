package unicam.piattaforma_filiera_agricola;

public class HandlerGestioneCarrello {

    public void aggiungiProdottoAlCarrello(Acquirente acquirente, Prodotto prodotto) {
        acquirente.getCarrello().aggiungiProdotto(prodotto);
        System.out.println("Prodotto aggiunto: " + prodotto.getNomeProdotto());
    }

    public void rimuoviProdottoDalCarrello(Acquirente acquirente, Prodotto prodotto) {
        acquirente.getCarrello().rimuoviProdotto(prodotto);
        System.out.println("Prodotto rimosso: " + prodotto.getNomeProdotto());
    }

    public void aggiungiPacchettoAlCarrello(Acquirente acquirente, PacchettoProdotti pacchetto) {
        acquirente.getCarrello().aggiungiPacchetto(pacchetto);
        System.out.println("Pacchetto aggiunto.");
    }

    public void rimuoviPacchettoDalCarrello(Acquirente acquirente, PacchettoProdotti pacchetto) {
        acquirente.getCarrello().rimuoviPacchetto(pacchetto);
        System.out.println("Pacchetto rimosso.");
    }

    public void svuotaCarrello(Acquirente acquirente) {
        acquirente.getCarrello().svuotaCarrello();
        System.out.println("Carrello svuotato.");
    }
}
