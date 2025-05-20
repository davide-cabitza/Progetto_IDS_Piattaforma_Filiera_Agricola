package unicam.piattaforma_filiera_agricola.model.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = ProdottoGrezzo.class, name = "produttore"),
        @JsonSubTypes.Type(value = ProdottoTrasformato.class, name = "trasformatore"),
        @JsonSubTypes.Type(value = ProdottoDistributore.class, name = "distributore"),
        @JsonSubTypes.Type(value = Pacchetto.class, name = "pacchetto_distributore")
})

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prodotto", discriminatorType = DiscriminatorType.STRING)
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProdotto;
    private double costo;
    private String descrizione;
    @Embedded
    private Indirizzo indirizzo;

    @ManyToOne
    @JoinColumn(name = "venditore_id")
    @OnDelete(action = OnDeleteAction.CASCADE) // se usi Hibernate
    private Venditore venditore;
    private boolean stato;


    public Prodotto(String nomeProdotto, double costo, String descrizione, Indirizzo indirizzo, Venditore venditore) {
        this.nomeProdotto = nomeProdotto;
        this.costo = costo;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.stato = false;
        this.venditore= venditore;
    }

    public Prodotto(String nome, String descrizione, double prezzo) {

    }

    public Prodotto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getCosto() {
        return costo;
    }

    public Indirizzo getIndirizzo() {return indirizzo;}

    public void setIndirizzo(Indirizzo indirizzo) {this.indirizzo=indirizzo;}

    public boolean isStato() {
        return stato;
    }

    public void setStato(boolean stato) {this.stato=stato;}

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Venditore getVenditore() {
        return venditore;
    }

    public void setVenditore(Venditore venditore) {
        this.venditore = venditore;
    }



}