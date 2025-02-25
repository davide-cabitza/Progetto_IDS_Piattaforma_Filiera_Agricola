package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public class Distributore extends Venditore{

    private ProdottoDistributore creaPacchetto;


    public Distributore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password, String partitaIva) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
    }

    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
        return null;
    }

    /*public void AggiungiProdotti(Prodotto prodotto){

    }*/

    public ProdottoDistributore getCreaPacchetto() {return creaPacchetto;}


}
