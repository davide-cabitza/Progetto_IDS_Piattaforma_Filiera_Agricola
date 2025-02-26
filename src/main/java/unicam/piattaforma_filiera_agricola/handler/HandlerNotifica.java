package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.INotfica;
import unicam.piattaforma_filiera_agricola.UtenteLoggato;

public class HandlerNotifica implements INotfica {

    @Override
    public void inviaNotifica(UtenteLoggato destinatario, String messaggio) {
        System.out.println("Notifica inviata a " + destinatario.getNome() + ": " + messaggio);
    }
}
