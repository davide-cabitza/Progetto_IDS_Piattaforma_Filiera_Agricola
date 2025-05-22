package unicam.piattaforma_filiera_agricola.model.payment;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.buyer.Acquirente;
import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Acquirente acquirente;

    @OneToOne(cascade = CascadeType.ALL)
    private Carrello carrello;

    @OneToOne(cascade = CascadeType.ALL)
    private Ricevuta ricevuta;

    public Pagamento() {}

    public Pagamento(Acquirente acquirente, Carrello carrello, Ricevuta ricevuta) {
        this.acquirente = acquirente;
        this.carrello = carrello;
        this.ricevuta = ricevuta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Acquirente getAcquirente() {
        return acquirente;
    }

    public void setAcquirente(Acquirente acquirente) {
        this.acquirente = acquirente;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Ricevuta getRicevuta() {
        return ricevuta;
    }

    public void setRicevuta(Ricevuta ricevuta) {
        this.ricevuta = ricevuta;
    }
}
