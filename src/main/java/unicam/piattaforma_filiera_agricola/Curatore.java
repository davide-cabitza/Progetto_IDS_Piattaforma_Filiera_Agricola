package unicam.piattaforma_filiera_agricola;

public class Curatore extends UtenteLoggato implements IValidate{
<<<<<<< HEAD
    public Curatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password) {
=======
    public Curatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente) {
>>>>>>> 5bb57980caaa1e13574ded6bc1ae56be712c27e5
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente);
    }

    @Override
    public void validateProduct(Prodotto p) {

    }

    @Override
    public void validateEvent(Evento e) {

    }
}
