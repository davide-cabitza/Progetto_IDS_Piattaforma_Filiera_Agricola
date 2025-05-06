package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Evento {
    private final String idEvento;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private String localita;
    private int maxPartecipanti;
    private String nome;
    private String descrizione;
    private final AnimatoreFiliera creatore;
    private final List<PartecipazioneEvento> partecipanti;
    private final List<Invitation> inviti;

    public Evento(String idEvento,
                  LocalDate dataInizio,
                  LocalDate dataFine,
                  String localita,
                  int maxPartecipanti,
                  String nome,
                  String descrizione,
                  AnimatoreFiliera creatore) {
        this.idEvento = idEvento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.localita = localita;
        this.maxPartecipanti = maxPartecipanti;
        this.nome = nome;
        this.descrizione = descrizione;
        this.creatore = creatore;
        this.partecipanti = new ArrayList<>();
        this.inviti = new ArrayList<>();
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
    public List<PartecipazioneEvento> getPartecipanti() { return Collections.unmodifiableList(partecipanti); }
    public List<Invitation> getInviti() { return Collections.unmodifiableList(inviti); }

    /**
     * Aggiunge una partecipazione all'evento.
     */
    public void aggiungiPartecipante(UtenteLoggato partecipante) {
        if (partecipanti.size() >= maxPartecipanti) {
            throw new IllegalStateException("Numero massimo di partecipanti raggiunto");
        }
        String idPart = UUID.randomUUID().toString();
        PartecipazioneEvento pe = new PartecipazioneEvento(idPart, this, partecipante, LocalDateTime.now());
        partecipanti.add(pe);
    }

    /**
     * Aggiunge un invito all'evento.
     */
    public void aggiungiInvito(AnimatoreFiliera mittente, Venditore destinatario) {
        String idInv = UUID.randomUUID().toString();
        Invitation invito = new Invitation(idInv, mittente, destinatario, this, LocalDateTime.now());
        inviti.add(invito);
    }
}
