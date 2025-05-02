package unicam.piattaforma_filiera_agricola;

import java.util.*;

public class Distributore extends Venditore {
    private final List<Pacchetto> pacchetti;

    public Distributore(String id, String nome, String cognome, String email) {
        super(id, nome, cognome, email, Ruolo.DISTRIBUTORE);
        this.pacchetti = new ArrayList<>();
    }

    /**
     * Restituisce la lista dei pacchetti creati dal distributore.
     */
    public List<Pacchetto> getPacchetti() {
        return Collections.unmodifiableList(pacchetti);
    }

    /**
     * Crea un nuovo pacchetto di prodotti.
     */
    public Pacchetto creaPacchetto(String nome, List<Prodotto> prodotti, double prezzoTotale) {
        String idPacchetto = UUID.randomUUID().toString();
        Pacchetto pacchetto = new Pacchetto(idPacchetto, nome, prodotti, prezzoTotale, this);
        pacchetti.add(pacchetto);
        return pacchetto;
    }

    /**
     * Modifica un pacchetto esistente.
     */
    public void modificaPacchetto(Pacchetto pacchetto, String nuovoNome, double nuovoPrezzo) {
        if (!pacchetti.contains(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non gestito da questo distributore");
        }
        pacchetto.setNome(nuovoNome);
        pacchetto.setPrezzoTotale(nuovoPrezzo);
    }

    /**
     * Elimina un pacchetto esistente.
     */
    public void eliminaPacchetto(Pacchetto pacchetto) {
        if (!pacchetti.remove(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non trovato");
        }
    }

    /**
     * Invia una richiesta di pubblicazione del pacchetto al Curatore.
     */
    public void inviaRichiestaPubblicazione(Pacchetto pacchetto) {
        if (!pacchetti.contains(pacchetto)) {
            throw new IllegalArgumentException("Pacchetto non gestito da questo distributore");
        }
        String idRichiesta = UUID.randomUUID().toString();
        RichiestaPubblicazione richiesta = new RichiestaPubblicazione(
                idRichiesta, this, pacchetto, LocalDateTime.now()
        );
        CuratoreService.inoltraRichiesta(richiesta);
    }

    /**
     * Elimina il profilo del Distributore insieme a tutti i pacchetti creati.
     */
    public void eliminaProfilo() {
        for (Pacchetto p : new ArrayList<>(pacchetti)) {
            eliminaPacchetto(p);
        }
        AccountService.deleteAccount(getId());
    }

}
