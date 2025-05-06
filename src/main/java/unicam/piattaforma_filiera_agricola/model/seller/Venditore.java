package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.UtenteLoggato;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Date;
import java.util.List;

public abstract class Venditore extends UtenteLoggato {

    protected String partitaIva;
    protected List<Prodotto> listaProdotti;
    protected List<String> certificatiProdotto;
    protected List<String> certificatiAzienda;


    public Venditore(int id, String nome, String email, String password, int numeroTelefono, Ruolo ruolo,
                 String indirizzo, String NomeUtente, String partitaIva, List<Prodotto> listaProdotti, List<String> certificatiProdotto, List<String> certificatiAzienda)  {
        super(id,nome,email, password, numeroTelefono, ruolo);
        this.partitaIva=partitaIva;
        this.listaProdotti=listaProdotti;
        this.certificatiProdotto=certificatiProdotto;
        this.certificatiAzienda=certificatiAzienda;
    }



    public abstract Prodotto creaProdotto();

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


    public List<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(List<Prodotto> listaProdotti) {
    this.listaProdotti=listaProdotti;
    }


    public List<String> getCertificatiAzienda() {
        return certificatiAzienda;
    }

    public void setCertificatiAzienda(List<String> certificatiAzienda) {
        this.certificatiAzienda=certificatiAzienda;
    }

    public List<String> getCertificatiProdotto() {
        return certificatiProdotto;
    }

    public void setCertificatiProdotto(List<String> certificatiProdotto) {
        this.certificatiProdotto = certificatiProdotto;
    }
}
