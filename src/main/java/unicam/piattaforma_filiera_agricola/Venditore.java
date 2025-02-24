package unicam.piattaforma_filiera_agricola;

import java.util.List;

public abstract class Venditore extends UtenteLoggato {

protected String partitaIva;
protected List<Prodotto> listaProdotti;
protected Enum certificatiProdotto;
protected String certificatiAzienda;


public Venditore(String partitaIva) {
this.partitaIva=partitaIva;
}
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public int getNumeroTelefono() {
        return super.getNumeroTelefono();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getIndirizzo() {
        return super.getIndirizzo();
    }

    @Override
    public String getNomeUtente() {
        return super.getNomeUtente();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
    this.listaProdotti=listaProdotti;
    }

    public Enum getCertificatiProdotto() {
        return certificatiProdotto;
    }

    public void setCertificatiProdotto(Enum certificatiProdotto) {
    this.certificatiProdotto=certificatiProdotto;
    }

    public String getCertificatiAzienda() {
        return certificatiAzienda;
    }

    public void setCertificatiAzienda(String certificatiAzienda) {
        this.certificatiAzienda=certificatiAzienda;
    }
}
