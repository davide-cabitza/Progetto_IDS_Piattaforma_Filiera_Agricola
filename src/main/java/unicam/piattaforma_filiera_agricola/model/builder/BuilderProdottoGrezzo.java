package unicam.piattaforma_filiera_agricola.model.builder;

import jakarta.persistence.*;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoGrezzo;

import java.util.Date;

public class BuilderProdottoGrezzo implements IBuilder{

    private ProdottoGrezzo risultato;

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
    private String processoProduttivo;
    private Venditore venditore;


    @Override
    public void reset(){
        risultato = new ProdottoGrezzo(nomeProdotto, costo, descrizione, location, venditore, processoProduttivo);
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
    public void BuildProcesso(String processoProduttivo){
        this.processoProduttivo = processoProduttivo;
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
        this.dataInserimento = dataInserimento;
    }

    public ProdottoGrezzo getRisultato() {
        return this.risultato;
    }
}
