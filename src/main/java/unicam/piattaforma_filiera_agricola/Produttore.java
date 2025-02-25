package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Produttore extends Venditore implements ISeller {

    public String processoColtivazione;

    public Produttore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String
            password, String partitaIva, String processoColtivazione) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
        this.processoColtivazione = processoColtivazione;
    }

    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date
            data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
        return null;
    }

    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modifyProdotto(Prodotto p) {

    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoColtivazione) {
        this.processoColtivazione = processoColtivazione;
    }

}


