package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Trasformatore extends Venditore implements ISeller{

    public String processoTrasformazione;

    public Trasformatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password, String partitaIva,String processoTrasformazione) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
        this.processoTrasformazione = processoTrasformazione;
    }

    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
        return null;
    }

    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modifyProdotto(Prodotto p) {

    }

    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoTrasformazione) {
        this.processoTrasformazione = processoTrasformazione;
    }
}
