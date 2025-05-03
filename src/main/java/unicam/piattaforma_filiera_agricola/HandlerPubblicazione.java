package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class HandlerPubblicazione implements IValidate{

    private List<Prodotto> prodottiVerificati = new ArrayList<>();
    private List<Evento> eventiVerificati = new ArrayList<>();
    private HandlerNotifica handlerNotifica;

    public HandlerPubblicazione(HandlerNotifica handlerNotifiche) {
        this.handlerNotifica= handlerNotifiche;
    }

    @Override
    public void approvaPubblicazioneProdotto(Prodotto p) {
        prodottiVerificati.add(p);
        System.out.println("Prodotto approvato: " + p.getNomeProdotto());
        handlerNotifica.inviaNotifica(p.getCreatore(), "Il tuo prodotto '" + p.getNomeProdotto() + "' è stato approvato!");
    }

    @Override
    public void approvaPubblicazioneEvento(Evento e) {
        eventiVerificati.add(e);
        System.out.println("Evento approvato: " + e.getNomeEvento());
        handlerNotifica.inviaNotifica(e.getCreatore(),"Il tuo evento '" + e.getNomeEvento() + "' è stato approvato!");
    }

    @Override
    public void rifiutaPubblicazioneProdotto(Prodotto p) {
        System.out.println("Prodotto rifiutato: " + p.getNomeProdotto());
        handlerNotifica.inviaNotifica(p.getCreatore(), "Il tuo prodotto '" + p.getNomeProdotto() + "' è stato rifiutato.");
    }


    @Override
    public void rifiutaPubblicazioneEvento(Evento e) {
        System.out.println("Evento rifiutato: " + e.getNomeEvento());
        handlerNotifica.inviaNotifica(e.getCreatore(), "Il tuo evento '" + e.getNomeEvento() + "' è stato rifiutato.");
    }
}
