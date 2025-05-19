package unicam.piattaforma_filiera_agricola.model.animatore;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvento;
    private String nome;
    private String descrizione;
    private int maxPartecipanti;
    @Embedded
    private Indirizzo localita;
    @ManyToOne(optional = false)
    @JsonBackReference
    private AnimatoreFiliera creatore;
    private LocalDate dataInizio = LocalDate.now();
    private LocalDate dataFine;

    public Evento() {

    }

    public Evento(String nome,
                  String descrizione,
                  int maxPartecipanti,
                  Indirizzo localita,
                  AnimatoreFiliera creatore,
                  LocalDate dataFine) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.maxPartecipanti = maxPartecipanti;
        this.localita = localita;
        this.creatore = creatore;
        this.dataFine = dataFine;
    }

    // Getter e setter
    public Long getIdEvento() { return idEvento; }
    public void setIdEvento(Long idEvento) { this.idEvento = idEvento; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public int getMaxPartecipanti() { return maxPartecipanti; }
    public void setMaxPartecipanti(int maxPartecipanti) { this.maxPartecipanti = maxPartecipanti; }

    public Indirizzo getLocalita() { return localita; }
    public void setLocalita(Indirizzo localita) { this.localita = localita; }

    public AnimatoreFiliera getCreatore() {
        return creatore;
    }
    public void setCreatore(AnimatoreFiliera creatore) {
        this.creatore = creatore;
    }

    public LocalDate getDataInizio() { return dataInizio; }
    public void setDataInizio(LocalDate dataInizio) { this.dataInizio = dataInizio; }

    public LocalDate getDataFine() { return dataFine; }
    public void setDataFine(LocalDate dataFine) { this.dataFine = dataFine; }






}
