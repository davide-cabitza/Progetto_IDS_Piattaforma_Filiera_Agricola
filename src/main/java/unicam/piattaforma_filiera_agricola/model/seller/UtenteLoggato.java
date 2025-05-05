package unicam.piattaforma_filiera_agricola.model.seller;

public abstract class UtenteLoggato {

    private final String id;
    private String nome;
    private String cognome;
    private String email;
    private final Ruolo ruolo;

    public UtenteLoggato(String id,
                         String nome,
                         String cognome,
                         String email,
                         Ruolo ruolo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
