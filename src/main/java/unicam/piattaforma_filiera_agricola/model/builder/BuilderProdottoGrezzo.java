package unicam.piattaforma_filiera_agricola.model.builder;

import unicam.piattaforma_filiera_agricola.model.product.ProdottoGrezzo;

import java.util.Date;

public class BuilderProdottoGrezzo implements Builder{

    private ProdottoGrezzo risultato;

    private int id;
    private String nomeProdotto;
    private String descrizione;
    private String processoProduttivo;
    private String certificati;
    private double costo;
    private int quantitativo;
    private int id_venditore;
    private Date dataInserimento;


    @Override
    public void reset(){
        risultato = new ProdottoGrezzo(id, nomeProdotto, descrizione, processoProduttivo, certificati, costo, quantitativo, id_venditore, dataInserimento);
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
