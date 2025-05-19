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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nomeProdotto;
    private double costo;
    private String descrizione;
    private String certificazioni;
    private Indirizzo indirizzo;
    private int id_venditore;
    private boolean stato;
    private int quantita;


    public Prodotto(String id, String nomeProdotto, String descrizione, String certificazioni, Indirizzo indirizzo, int id_venditore, double costo, int quantita) {
        this.nomeProdotto = nomeProdotto;
        this.costo = costo;
        this.descrizione = descrizione;
        this.certificazioni = certificazioni;
        this.indirizzo = indirizzo;
        this.stato = false;
        this.id_venditore = id_venditore;
        this.quantita = quantita;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getIDVenditore() {
        return id_venditore;
    }

    public void setIDVenditore(int venditore) {
        this.id_venditore = venditore;
    }

    public int getQuantita(){return quantita;}

    public void setQuantita(int quantity){this.quantita=quantity;}


}