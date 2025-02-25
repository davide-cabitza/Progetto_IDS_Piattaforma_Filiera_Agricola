package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Prodotto {
    private int id;
    private String nomeProdotto;
    private String descrizione;
    private String certificati;
    private double costo;
    private int quantitativo;
    private String categoria;
    private int id_venditore;
    private Date dataInserimento;

    public Prodotto(int id, String nomeProdotto, String descrizione, String certificati, double costo, int quantitativo, String categoria, int id_venditore, Date dataInserimento) {
        this.id = id;
        this.nomeProdotto = nomeProdotto;
        this.descrizione = descrizione;
        this.certificati = certificati;
        this.costo = costo;
        this.quantitativo = quantitativo;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
