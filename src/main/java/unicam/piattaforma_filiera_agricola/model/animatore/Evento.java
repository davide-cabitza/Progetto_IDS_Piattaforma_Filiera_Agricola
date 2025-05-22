package unicam.piattaforma_filiera_agricola.model.animatore;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;
    private String nome;
    private String descrizione;
    private int maxPartecipanti;
    @Embedded
    private Indirizzo luogo;
    @ManyToOne(optional = true)
    @JsonBackReference
    private AnimatoreFiliera creatore;
    private LocalDate dataInizio = LocalDate.now();
    private LocalDate dataFine;
    @ManyToMany
    private List<Venditore> venditoriInvitati = new ArrayList<>();

    public Evento() {

    }

    public Evento(String nome,
                  String descrizione,
                  int maxPartecipanti,
                  Indirizzo luogo,
                  AnimatoreFiliera creatore,
                  LocalDate dataFine, List<Venditore> venditoriInvitati) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.maxPartecipanti = maxPartecipanti;
        this.luogo = luogo;
        this.creatore = creatore;
        this.dataFine = dataFine;
        this.venditoriInvitati = venditoriInvitati;
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

    public Indirizzo getLuogo() { return luogo; }
    public void setLuogo(Indirizzo luogo) { this.luogo = luogo; }

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


    public List<Venditore> getVenditoriInvitati() {
        return venditoriInvitati;
    }

    public void setVenditoriInvitati(List<Venditore> venditoriInvitati) {
        this.venditoriInvitati = venditoriInvitati;
    }
}
