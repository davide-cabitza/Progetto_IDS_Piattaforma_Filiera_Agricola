package unicam.piattaforma_filiera_agricola.model.product;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.util.Date;

/*
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProdottoGrezzo.class, name = "produttore"),
        @JsonSubTypes.Type(value = ProdottoTrasformatore.class, name = "trasformatore"),
        @JsonSubTypes.Type(value = ProdottoDistributore.class, name = "distributore")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_prodotto", discriminatorType = DiscriminatorType.STRING)

 */
public class Prodotto {
    private String nomeProdotto;
    private double costo;
    private String descrizione;
    private Long id;
    private Indirizzo indirizzo;
    private Venditore venditore;
    private boolean stato;


    public Prodotto(String nomeProdotto, double costo, String descrizione,Indirizzo indirizzo, Venditore venditore) {
        this.nomeProdotto = nomeProdotto;
        this.costo = costo;
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.stato = false;
        this.venditore= venditore;
    }

    public Prodotto(String nome, String descrizione, double prezzo) {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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