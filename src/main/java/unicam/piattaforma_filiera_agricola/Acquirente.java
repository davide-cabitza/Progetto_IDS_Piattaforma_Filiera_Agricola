package unicam.piattaforma_filiera_agricola;

public class Acquirente extends UtenteLoggato {

    String indirizzoSpedizioni;
    public Acquirente(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password, String indirizzoSpedizioni) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password);
        this.indirizzoSpedizioni = indirizzoSpedizioni;
    }

    public void aggiungiAlCarrello(){

    }

    public String getIndirizzoSpedizioni() {
        return indirizzoSpedizioni;
    }

    public void setIndirizzoSpedizioni(String indirizzoSpedizioni) {
        this.indirizzoSpedizioni = indirizzoSpedizioni;
    }
}
