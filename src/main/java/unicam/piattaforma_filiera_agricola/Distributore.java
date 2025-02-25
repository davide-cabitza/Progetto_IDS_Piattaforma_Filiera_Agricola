package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public class Distributore extends Venditore implements ISeller{

    private List<PacchettoProdotti> pacchetti;


    public Distributore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String password, String partitaIva) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, password, partitaIva);
    }

    /*
    @Override
    public Prodotto creaProdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data, CategoriaProdotto categoriaProdotto, Certificati certificatiProdotto) {
        Prodotto nuovoProdotto = new Prodotto(id, nome,descrizione,costo,quantitativo,data,categoriaProdotto,certificatiProdotto);
        listaProdotti.add(nuovoProdotto); // Aggiungiamo il prodotto alla lista del venditore
        return nuovoProdotto;    }

     */


    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modifyProdotto(Prodotto p) {

    }

    public PacchettoProdotti creaPacchetto(String nomePacchetto, float prezzoBase) {
        PacchettoProdotti nuovoPacchetto = new PacchettoProdotti(nomePacchetto, prezzoBase);
        pacchetti.add(nuovoPacchetto);
        return nuovoPacchetto;
    }

    public void aggiungiProdottoAlPacchetto(PacchettoProdotti pacchetto, Prodotto prodotto) {
        pacchetto.aggiungiProdotto(prodotto);
    }

    // Metodo per ottenere la lista di pacchetti creati dal distributore
    public List<PacchettoProdotti> getPacchetti() {
        return pacchetti;
    }


}
