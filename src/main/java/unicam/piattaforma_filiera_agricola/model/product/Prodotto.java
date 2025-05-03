package unicam.piattaforma_filiera_agricola.model.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.util.Date;

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
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeProdotto;
    private double costo;
    private String descrizione;
    private String certificati;
    private int quantitativo;
    private int id_venditore;
    private Date dataInserimento;

    public Prodotto(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo,int id_venditore, Date dataInserimento) {
        this.id = id;
        this.nomeProdotto = nomeProdotto;
        this.costo = costo;
        this.descrizione = descrizione;
        this.certificati = certificati;
        this.quantitativo = quantitativo;
        this.id_venditore = id_venditore;
        this.dataInserimento = dataInserimento;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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


}
