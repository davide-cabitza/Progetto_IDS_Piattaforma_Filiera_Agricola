package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public class Trasformatore extends Venditore implements ISeller {

    public String processoTrasformazione;

    public Trasformatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String partitaIva,
                         List<Prodotto> listaProdotti, String certificatiProdotto, String certificatiAzienda, String processoTrasformazione) {

        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.processoTrasformazione = processoTrasformazione;
    }


    public String getProcessoTrasformazione() {
        return processoTrasformazione;
    }

    public void setProcessoTrasformazione(String processoTrasformazione) {
        this.processoTrasformazione = processoTrasformazione;
    }

    @Override
    public Prodotto creaProdotto(int id, String nome, String descrizione, String certificatiProdotto, Float costo, int quantitativo, String categoriaProdotto, int idVenditore, Date dataInserimento) {
        return null;
    }

    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modifyProdotto(Prodotto p) {

    }
}
