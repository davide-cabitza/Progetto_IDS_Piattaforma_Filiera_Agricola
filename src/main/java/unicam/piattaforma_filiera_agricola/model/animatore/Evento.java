package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Evento {
    private final String idEvento;
    private String nome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private String localita;
    private int maxPartecipanti;
    private String descrizione;
    private AnimatoreFiliera creatore;
    private List<Venditore> invitati;

    public Evento(String idEvento,
                  String nomr,
                  LocalDate dataInizio,
                  LocalDate dataFine,
                  String localita,
                  int maxPartecipanti,
                  String descrizione,
                  AnimatoreFiliera creatore) {
        this.idEvento = idEvento;
        this.nome = nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.localita = localita;
        this.maxPartecipanti = maxPartecipanti;
        this.descrizione = descrizione;
        this.creatore = creatore;
        this.invitati = invitati;
    }

    // Getter e setter
    public String getIdEvento() { return idEvento; }
    public LocalDate getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDate dataInizio) { this.dataInizio = dataInizio; }
    public LocalDate getDataFine() { return dataFine; }
    public void setDataFine(LocalDate dataFine) { this.dataFine = dataFine; }
    public String getLocalita() { return localita; }
    public void setLocalita(String localita) { this.localita = localita; }
    public int getMaxPartecipanti() { return maxPartecipanti; }
    public void setMaxPartecipanti(int maxPartecipanti) { this.maxPartecipanti = maxPartecipanti; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public AnimatoreFiliera getCreatore() { return creatore; }
    public List<Venditore> getInvitati() { return Collections.unmodifiableList(invitati); }


}
