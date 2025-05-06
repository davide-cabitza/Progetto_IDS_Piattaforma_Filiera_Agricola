package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Date;
import java.util.List;

public class Produttore extends Venditore implements ISeller {

    public String processoColtivazione;

    public Produttore(int id, String nomeUtente, String nome, String email, String password, int numeroTelefono, Ruolo ruolo, String indirizzo, String NomeUtente, String partitaIva,
                      List<Prodotto> listaProdotti, List<String> certificatiProdotto, List<String> certificatiAzienda, String processoColtivazione) {

        super(id, nomeUtente, nome, email, password, numeroTelefono, ruolo,
                indirizzo, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.processoColtivazione = processoColtivazione;
    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoColtivazione) {
        this.processoColtivazione = processoColtivazione;
    }

    @Override
    public Prodotto creaProdotto() {
        return null;
    }

    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modificaProdotto(Prodotto p) {

    }
}


