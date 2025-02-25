package unicam.piattaforma_filiera_agricola;

public class Curatore extends UtenteLoggato implements IValidate{
    public Curatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente);
    }

    @Override
    public void validateProduct(Prodotto p) {

    }

    @Override
    public void validateEvent(Evento e) {

    }
}
