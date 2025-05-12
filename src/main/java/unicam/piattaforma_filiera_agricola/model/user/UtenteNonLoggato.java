package unicam.piattaforma_filiera_agricola.model.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Rappresenta l'utente non autenticato che può registrarsi o accedere.
 */
public class UtenteNonLoggato {

    // Archivio degli utenti registrati
    private static final List<UtenteLoggato> utentiRegistrati = new ArrayList<>();

    /**
     * Registra un nuovo utente loggato.
     * Verifica che l'email non sia già presente.
     * @param nuovoUtente istanza di UtenteLoggato da registrare
     * @return l'utente registrato
     * @throws IllegalArgumentException se l'email è già registrata
     */
    public static UtenteLoggato registrati(UtenteLoggato nuovoUtente) {
        // Controllo unicità email
        boolean esiste = utentiRegistrati.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(nuovoUtente.getEmail()));
        if (esiste) {
            throw new IllegalArgumentException("Email già registrata: " + nuovoUtente.getEmail());
        }
        utentiRegistrati.add(nuovoUtente);
        return nuovoUtente;
    }

    /**
     * Effettua il login di un utente esistente.
     * @param email    email utilizzata per la registrazione
     * @param password password associata
     * @return utente loggato
     * @throws IllegalArgumentException se credenziali non valide
     */
    public static UtenteLoggato accedi(String email, String password) {
        Optional<UtenteLoggato> opt = utentiRegistrati.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email)
                        && u.getPassword().equals(password))
                .findFirst();
        if (opt.isEmpty()) {
            throw new IllegalArgumentException("Credenziali non valide");
        }
        return opt.get();
    }

    /**
     * Restituisce la lista degli utenti registrati (solo per debug).
     */
    public static List<UtenteLoggato> getUtentiRegistrati() {
        return List.copyOf(utentiRegistrati);
    }
}
