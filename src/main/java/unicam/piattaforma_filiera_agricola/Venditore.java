package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public abstract class Venditore extends UtenteLoggato {

protected String partitaIva;
protected List<Prodotto> listaProdotti;
protected Enum certificatiProdotto;
protected String certificatiAzienda;


public Venditore(int id,String nome,String email, int numeroTelefono,String indirizzo,String NomeUtente,String password,String partitaIva)  {
    super(id,nome,email,numeroTelefono,indirizzo,NomeUtente,password);
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


    public String getCertificatiAzienda() {
        return certificatiAzienda;
    }

    public void setCertificatiAzienda(String certificatiAzienda) {
        this.certificatiAzienda=certificatiAzienda;
    }

    public abstract Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto);

    @Override
    public void caricaPrdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
        Prodotto prodotto = creaProdotto(id,nome,descrizione,costo,quantitativo,data,categoriaProdotto,certificatiProdotto);
    }
}
