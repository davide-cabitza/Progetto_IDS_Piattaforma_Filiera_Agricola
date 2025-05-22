package unicam.piattaforma_filiera_agricola.model.seller;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

/**
 * Classe astratta per tutti i Venditori (Produttore, Distributore, Trasformatore).
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Trasformatore.class, name = "trasformatore"),
        @JsonSubTypes.Type(value = Produttore.class, name = "produttore"),
        @JsonSubTypes.Type(value = Distributore.class, name = "distributore")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_venditore", discriminatorType = DiscriminatorType.STRING)
public abstract class Venditore implements IVenditore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    private Indirizzo indirizzo;

    public Venditore(String nome, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public Venditore() {}

    public abstract Prodotto createProdotto(String nome, double costo, String descrizione);

    @Override
    public void loadProduct(String nome, double costo, String descrizione) {
        Prodotto product = createProdotto(nome, costo, descrizione);
    }

    public Long getId() { return this.id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Indirizzo getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }
}
