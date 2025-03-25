package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.event.Evento;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

public class HandlerGestionePost {

    public void eliminaProdotto(Prodotto prodotto) {
        // Logica per eliminare il prodotto dalla pagina del marketplace
        System.out.println("Prodotto eliminato con successo.");
    }


    public void modificaProdotto(Prodotto prodotto) {
        // Logica per aggiornare le informazioni sul prodotto
        System.out.println("Prodotto modificato con successo.");
    }


    public void eliminaEvento(Evento evento) {
        // Logica per eliminare l'evento dalla pagina degli eventi
        System.out.println("Evento eliminato con successo.");
    }


    public void modificaEvento(Evento evento) {
        // Logica per aggiornare le informazioni sull'evento
        System.out.println("Evento modificato con successo.");
    }


}
