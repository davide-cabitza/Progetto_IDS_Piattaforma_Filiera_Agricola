package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.curatore.Curatore;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.seller.Distributore;
import unicam.piattaforma_filiera_agricola.model.seller.Produttore;
import unicam.piattaforma_filiera_agricola.model.seller.Trasformatore;
import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;

import java.util.Map;
import java.util.HashMap;

public class UtenteNonLoggato implements IRegister, IAccess {

    // Simulazione di un database di utenti
    private static Map<String, UtenteLoggato> utentiRegistrati = new HashMap<>();

    // Metodo per registrare un nuovo utente
    @Override
    public String register(int id, String nome, String email, String password, int numeroTelefono, String indirizzo, String NomeUtente, UtenteLoggato tipoUtente) {
        // Verifica se l'utente è già registrato
        if (utentiRegistrati.containsKey(email)) {
            return "Utente già registrato.";
        }

        UtenteLoggato nuovoUtente = null;
        switch (tipoUtente) {
            case "Acquirente":
                nuovoUtente = new Acquirente(email, password);
                break;
            case "Produttore":
                nuovoUtente = new Produttore(email, password);
                break;
            case "Trasformatore":
                nuovoUtente = new Trasformatore(email, password);
                break;
            case "Distributore":
                nuovoUtente = new Distributore(email, password);
                break;
            case "AnimatoreFiliera":
                nuovoUtente = new AnimatoreFiliera(email, password);
                break;
            case "Curatore":
                nuovoUtente = new Curatore(email, password);
                break;
            case "GestorePiattaforma":
                nuovoUtente = new GestorePiattaforma(email, password);
                break;
            default:
                return "'Tipo di Utente' inserito non è valido.";
        }

        // Aggiungi l'utente al "database"
        utentiRegistrati.put(email, nuovoUtente);
        return "Registrazione avvenuta con successo.";
    }

    // Metodo per eseguire l'accesso
    @Override
    public String access(String email, String password) {
        // Verifica se l'utente è registrato
        UtenteLoggato utente = utentiRegistrati.get(email);
        if (utente == null) {
            return "Utente non trovato.";
        }

        // Verifica se la password è corretta
        if (!utente.getPassword().equals(password)) {
            return "Password errata.";
        }

        return "accesso effettuato correttamente.";
    }

}
