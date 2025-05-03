package unicam.piattaforma_filiera_agricola;

public interface IRegister {

    String register(int id,String nome,String email, String password, int numeroTelefono,String indirizzo,String NomeUtente, UtenteLoggato tipoUtente);
}
