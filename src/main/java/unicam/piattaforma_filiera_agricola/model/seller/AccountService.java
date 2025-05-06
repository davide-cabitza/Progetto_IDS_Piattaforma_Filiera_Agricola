package unicam.piattaforma_filiera_agricola.model.seller;

/**
 * Service per operazioni legate all'account utente: cancellazione, aggiornamento credenziali.
 */
public class AccountService {

    /**
     * Elimina un account utente e tutti i dati associati.
     * @param idUtente identificativo dell'utente da eliminare
     */
    public static void deleteAccount(String idUtente) {
        // Logica di cancellazione account (DB, storage)
    }

    /**
     * Aggiorna le informazioni di contatto di un utente.
     */
    public static void updateContactInfo(String idUtente, String email, String telefono) {
        // Logica di aggiornamento
    }
}
