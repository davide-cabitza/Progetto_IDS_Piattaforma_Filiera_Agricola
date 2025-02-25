package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Trasformatore extends Venditore {

    public String processoTrasformazione;

    public Trasformatore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password, String partitaIva,String processoTrasformazione) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
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
}
