package unicam.piattaforma_filiera_agricola.model.seller;

/**
 * Classe base per tutti gli utenti autenticati nella piattaforma.
 */
public abstract class UtenteLoggato {
    private final String id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String cellNumber;
    private String indirizzo;
    private final Ruolo ruolo;

    public UtenteLoggato(String id,
                         String username,
                         String nome,
                         String cognome,
                         String email,
                         String password,
                         String cellNumber,
                         String indirizzo,
                         Ruolo ruolo) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.cellNumber = cellNumber;
        this.indirizzo = indirizzo;
        this.ruolo = ruolo;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
