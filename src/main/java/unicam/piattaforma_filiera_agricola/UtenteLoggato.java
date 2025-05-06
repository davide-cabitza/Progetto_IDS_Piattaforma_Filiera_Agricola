package unicam.piattaforma_filiera_agricola;

import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;

public abstract class UtenteLoggato {

    private final int id;
    private String nome;
    private String email;
    private String password;
    private int numeroTelefono;
    private final Ruolo ruolo;
    private String indirizzo;
    private String nomeUtente;

    public UtenteLoggato(int id,
                         String nomeUtente,
                         String nome,
                         String email,
                         String password,
                         int numeroTelefono,
                         String indirizzo,
                         Ruolo ruolo) {
        this.id = id;
        this.nomeUtente = nomeUtente;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.numeroTelefono = numeroTelefono;
        this.indirizzo = indirizzo;
        this.ruolo = ruolo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {this.password = password;}

    public int getNumeroTelefono(){return this.numeroTelefono;}

    public void setNumeroTelefono(int number){this.numeroTelefono=number;}

    public Ruolo getRuolo() {
        return ruolo;
    }
}
