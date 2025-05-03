package unicam.piattaforma_filiera_agricola;

public class HandlerNotifica implements INotfica {

    @Override
    public void inviaNotifica(UtenteLoggato destinatario, String messaggio) {
        System.out.println("Notifica inviata a " + destinatario.getNome() + ": " + messaggio);
    }
}
