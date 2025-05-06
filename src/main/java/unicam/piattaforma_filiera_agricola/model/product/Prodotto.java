package unicam.piattaforma_filiera_agricola.model.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.Indirizzo;

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
    private long id;
    private String nomeProdotto;
    private String descrizione;
    private String certificati;
    private double prezzo;
    private int quantitativo;
    private int id_venditore;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInserimento;
    @Embedded
    private Indirizzo location;

    public Prodotto(String nomeProdotto, String descrizione, String certificati, double prezzo, int quantitativo, int id_venditore, Indirizzo location) {
        this.nomeProdotto = nomeProdotto;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.certificati = certificati;
        this.quantitativo = quantitativo;
        this.id_venditore = id_venditore;
        this.location = location;
    }

    public Prodotto() {

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

    public String getCertificati() {
        return certificati;
    }

    public void setCertificati(String certificati) {
        this.certificati = certificati;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double costo) {
        this.prezzo = prezzo;
    }

    public int getQuantitativo() {
        return quantitativo;
    }

    public void setQuantitativo(int quantitativo) {
        this.quantitativo = quantitativo;
    }


    public int getId_venditore() {
        return id_venditore;
    }

    public void setId_venditore(int id_venditore) {
        this.id_venditore = id_venditore;
    }

    public Date getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(Date dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Indirizzo getLocation() {
        return location;
    }

    public void setLocation(Indirizzo location) {
        this.location = location;
    }


}
