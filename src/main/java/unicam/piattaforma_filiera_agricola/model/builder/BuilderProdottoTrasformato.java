package unicam.piattaforma_filiera_agricola.model.builder;

import unicam.piattaforma_filiera_agricola.model.product.ProdottoTrasformatore;

import java.util.Date;

public class BuilderProdottoTrasformato implements Builder{

    private ProdottoTrasformatore risultato;

    private int id;
    private String nomeProdotto;
    private String descrizione;
    private String processoTrasformazione;
    private String certificati;
    private double costo;
    private int quantitativo;
    private int id_venditore;
    private Date dataInserimento;


    @Override
    public void reset(){
        risultato = new ProdottoTrasformatore(id, nomeProdotto, descrizione, processoTrasformazione, certificati, costo, quantitativo, id_venditore, dataInserimento);
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
        this.dataInserimento = dataInserimento;
    }

    public ProdottoTrasformatore getRisultato() {
        return this.risultato;
    }
}
