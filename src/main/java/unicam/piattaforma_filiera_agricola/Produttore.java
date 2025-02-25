package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public class Produttore extends Venditore implements ISeller{

    public String processoColtivazione;

    public Produttore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String partitaIva,
                      List<Prodotto> listaProdotti, String certificatiProdotto, String certificatiAzienda, String processoColtivazione) {

        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.processoColtivazione = processoColtivazione;
    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoColtivazione) {
        this.processoColtivazione = processoColtivazione;
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


