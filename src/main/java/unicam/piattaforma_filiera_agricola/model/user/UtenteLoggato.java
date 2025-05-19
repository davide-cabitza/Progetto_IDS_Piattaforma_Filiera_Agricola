package unicam.piattaforma_filiera_agricola.model.user;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Embedded;
import unicam.piattaforma_filiera_agricola.model.seller.Ruolo;

/**
 * Classe base per tutti gli utenti autenticati nella piattaforma.
 */
@MappedSuperclass
public abstract class UtenteLoggato {
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String cellNumber;
    @Embedded
    private Indirizzo indirizzo;
    private Ruolo ruolo;

   public UtenteLoggato() {};

    public UtenteLoggato(Long id,
                         String username,
                         String nome,
                         String cognome,
                         String email,
                         String password,
                         String cellNumber,
                         Indirizzo indirizzo,
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

    public UtenteLoggato(Long id, String nome, String email, String password, int numeroTelefono, Ruolo ruolo, String indirizzo, String nomeUtente) {
    }

    public Long getId() {
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

    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
}
