package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Map;
import java.util.HashMap;

public class UtenteNonLoggato implements IRegister, IAccess {

    // Simulazione di un database di utenti
    private static Map<String, UtenteLoggato> utentiRegistrati = new HashMap<>();

    // Metodo per registrare un nuovo utente
    @Override
    public String register(String email, String password, String tipoUtente) {
        // Verifica se l'utente è già registrato
        if (utentiRegistrati.containsKey(email)) {
            return "Utente già registrato.";
        }

        UtenteLoggato nuovoUtente = null;
        switch (tipoUtente) {
            case "Venditore":
                nuovoUtente = new Venditore(email, password);
                break;
            case "AnimatoreDellaFiliera":
                nuovoUtente = new AnimatoreDellaFiliera(email, password);
                break;
            case "Curatore":
                nuovoUtente = new Curatore(email, password);
                break;
            default:
                return "Tipo di utente non valido.";
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
