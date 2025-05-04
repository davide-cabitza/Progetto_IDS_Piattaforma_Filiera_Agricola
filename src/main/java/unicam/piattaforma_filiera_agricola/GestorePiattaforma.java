package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;

public class GestorePiattaforma extends UtenteLoggato {


    public GestorePiattaforma(int id, String nome, String email, String password, int numeroTelefono, String indirizzo, String NomeUtente) {
        super(id, nome, email, password, numeroTelefono, indirizzo, NomeUtente);
    }
}
