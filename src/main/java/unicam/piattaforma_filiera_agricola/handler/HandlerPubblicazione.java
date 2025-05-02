package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.curatore.IValidate;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.ArrayList;
import java.util.List;

public class HandlerPubblicazione implements IValidate {

    private List<Prodotto> prodottiVerificati = new ArrayList<>();
    private HandlerNotifica handlerNotifica;

    public HandlerPubblicazione(HandlerNotifica handlerNotifiche) {
        this.handlerNotifica= handlerNotifiche;
    }

    @Override
    public void approvaProdotto(Prodotto p) {
        prodottiVerificati.add(p);
        System.out.println("Prodotto approvato: " + p.getNomeProdotto());
        handlerNotifica.inviaNotifica(p.getId_venditore(), "Il tuo prodotto '" + p.getNomeProdotto() + "' è stato ap" + "provato!");

    }

    @Override
    public void rifiutaProdotto(Prodotto p, String nota) {
        System.out.println("Prodotto rifiutato: " + p.getNomeProdotto());
        handlerNotifica.inviaNotifica(p.getId_venditore(), "Il tuo prodotto '" + p.getNomeProdotto() + "' è stato rifiutato per i seguenti motivi: " + nota);
    }

}
