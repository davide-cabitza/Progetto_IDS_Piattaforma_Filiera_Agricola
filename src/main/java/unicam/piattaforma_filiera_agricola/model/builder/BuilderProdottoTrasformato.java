package unicam.piattaforma_filiera_agricola.model.builder;

import jakarta.persistence.*;
import jakarta.persistence.TemporalType;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoTrasformato;

import java.util.Date;

public class BuilderProdottoTrasformato implements IBuilder{

    private ProdottoTrasformato risultato;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeProdotto;
    private String descrizione;
    private String certificati;
    private double costo;
    private int quantitativo;
    private int id_venditore;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInserimento;
    @Embedded
    private Indirizzo location;
    private String processoTrasformazione;
    private Venditore venditore;


    @Override
    public void reset(){
        risultato = new ProdottoTrasformato(nomeProdotto, costo, descrizione, location, venditore, processoTrasformazione);
    }

    @Override
    public void BuildNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    @Override
    public void BuildDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public void BuildProcesso(String processoTrasformazione){
        this.processoTrasformazione = processoTrasformazione;
    }

    @Override
    public void BuildCertificati(String certificati) {
        this.certificati = certificati;
    }

    @Override
    public void BuildCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public void BuildQuantitativo(int quantitativo) {
        this.quantitativo = quantitativo;
    }


    @Override
    public void BuildDataInserimento(Date dataInserimento) {
    }

    public ProdottoTrasformato getRisultato() {
        return this.risultato;
    }
}
