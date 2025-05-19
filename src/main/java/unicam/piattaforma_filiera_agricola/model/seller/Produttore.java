package unicam.piattaforma_filiera_agricola.model.seller;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.product.ProdottoGrezzo;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;

import java.util.Date;

public class Produttore extends Venditore{

    private String processoColtivazione;

    public Produttore(String id,
                      String username,
                      String nome,
                      String cognome,
                      String email,
                      String password,
                      String cellNumber,
                      Indirizzo indirizzo) {
        super(id, username, nome, cognome, email, password, cellNumber, indirizzo);
        this.processoColtivazione = processoColtivazione;
    }

    public String getProcessoColtivazione() {
        return processoColtivazione;
    }

    public void setProcessoColtivazione(String processoColtivazione) {
        this.processoColtivazione = processoColtivazione;
    }

    @Override
    public Prodotto createProduct(String nome, double costo, String descrizione) {
        return new ProdottoGrezzo(nome, costo, descrizione, getIndirizzo(), this,processoColtivazione);
    }

}




}
