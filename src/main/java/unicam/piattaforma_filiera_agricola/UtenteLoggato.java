package unicam.piattaforma_filiera_agricola;

public abstract class UtenteLoggato {

    private int id;
    private String nome;
    private String email;
    private int numeroTelefono;
    private String indirizzo;
    private String NomeUtente;
    private String password;

    public UtenteLoggato(int id,String nome,String email, int numeroTelefono,String indirizzo,String NomeUtente,String password) {
    this.id=id;
    this.nome=nome;
    this.email=email;
    this.numeroTelefono=numeroTelefono;
    this.indirizzo=indirizzo;
    this.NomeUtente=NomeUtente;
    this.password=password;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNomeUtente() {
        return NomeUtente;
    }

    public String getPassword() {
        return password;
    }
}
