package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;
import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;

public class GestorePiattaforma extends UtenteLoggato {


    public GestorePiattaforma(int id, String nome, String email, String password, int numeroTelefono, Ruolo ruolo, String indirizzo, String nomeUtente) {
        super(id, nome, email, password, numeroTelefono, ruolo, indirizzo, nomeUtente);
    }
}
