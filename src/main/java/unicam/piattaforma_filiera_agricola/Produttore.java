package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Produttore extends Venditore {

    public String processoColtivazione;

    public Produttore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String
            password, String partitaIva, String processoColtivazione) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
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
}


