package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Produttore extends Venditore {

    public Produttore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password,String partitaIva) {
        super(id,nome,email,numeroTelefono,indirizzo,NomeUtente,password,partitaIva);
    }

    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
return null;
    }


}
