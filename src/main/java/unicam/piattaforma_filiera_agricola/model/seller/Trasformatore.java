package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.Date;
import java.util.List;

public class Trasformatore extends Venditore implements ISeller {

    public String processoTrasformazione;

    public Trasformatore(int id, String nome, String nomeUtente, String email, String password, int numeroTelefono, Ruolo ruolo, String indirizzo, String NomeUtente, String partitaIva,
                         List<Prodotto> listaProdotti, List<String> certificatiProdotto, List<String> certificatiAzienda, String processoTrasformazione) {

        super(id, nomeUtente, nome, email, password, numeroTelefono, ruolo,
                indirizzo, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.processoTrasformazione = processoTrasformazione;
    }


    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoTrasformazione) {
        this.processoTrasformazione = processoTrasformazione;
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
