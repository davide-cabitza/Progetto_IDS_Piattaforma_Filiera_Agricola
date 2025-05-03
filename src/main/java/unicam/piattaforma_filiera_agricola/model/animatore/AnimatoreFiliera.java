package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.handler.HandlerAnimatore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimatoreFiliera extends UtenteLoggato {


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

    public AnimatoreFiliera(int id, String nome, String email, String password, int numeroTelefono, String indirizzo, String NomeUtente) {
        super(id, nome, email, password, numeroTelefono, indirizzo, NomeUtente);
    }

    // Getter e setter
    public String getIdEvento() {
        return idEvento;
    }
    public LocalDate getDataInizio() {
        return dataInizio;
    }
    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }
    public LocalDate getDataFine() {
        return dataFine;
    }
    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    public String getLocalita() {
        return localita;
    }
    public void setLocalita(String localita) {
        this.localita = localita;
    }
    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }
    public void setMaxPartecipanti(int maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public AnimatoreFiliera getCreatore() {
        return creatore;
    }
    public List<PartecipazioneEvento> getPartecipanti() {
        return Collections.unmodifiableList(partecipanti);
    }
    public List<Invitation> getInviti() {
        return Collections.unmodifiableList(inviti);
    }

    /**
     * Aggiunge una partecipazione all'evento.
     */
    public void aggiungiPartecipante(PartecipazioneEvento pe) {
        if (partecipanti.size() >= maxPartecipanti) {
            throw new IllegalStateException("Numero massimo di partecipanti raggiunto");
        }
        partecipanti.add(pe);
    }

    /**
     * Aggiunge un invito all'evento.
     */
    public void aggiungiInvito(Invitation invito) {
        inviti.add(invito);
    }
}

