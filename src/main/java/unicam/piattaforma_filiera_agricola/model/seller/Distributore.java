package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Date;
import java.util.List;

public class Distributore extends Venditore implements ISeller {

    public String processoDistribuzione;

    public Distributore(int id, String nomeUtente, String nome, String email, String password, int numeroTelefono, Ruolo ruolo, String indirizzo, String NomeUtente, String partitaIva,
                      List<Prodotto> listaProdotti, List<String> certificatiProdotto, List<String> certificatiAzienda, String processoColtivazione) {

        super(id, nomeUtente, nome, email, password, numeroTelefono, ruolo,
                indirizzo, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.processoDistribuzione = processoColtivazione;
    }

    public String getProcessoDistribuzione() {
        return processoDistribuzione;
    }

    public void setProcessoDistribuzione(String processoDistribuzione) {
        this.processoDistribuzione = processoDistribuzione;
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
