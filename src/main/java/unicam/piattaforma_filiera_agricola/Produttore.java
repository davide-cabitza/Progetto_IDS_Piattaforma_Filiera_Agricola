package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public class Produttore extends Venditore implements UtenteLoggato {

    public Produttore(String partitaIva,int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password) {
        super(partitaIva,id,nome,email,numeroTelefono,indirizzo,NomeUtente,password);
    }

    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {

    }


}
