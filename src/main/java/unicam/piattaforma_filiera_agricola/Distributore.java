package unicam.piattaforma_filiera_agricola;

import java.util.Date;
import java.util.List;

public class Distributore extends Venditore{

    private List<PacchettoProdotti> pacchetti;


    public Distributore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String partitaIva) {
        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, partitaIva);
    }


    @Override
    public Prodotto creaProdotto(int id, String nome, String descrizione, String certificatiProdotto, Float costo, int quantitativo, String categoriaProdotto, int idVenditore, Date dataInserimento) {
        return null;
    }

    public PacchettoProdotti creaPacchetto(int id, String nome, String descrizione, String certificatiProdotto, Float costo, int quantitativo, String categoriaProdotto, int idVenditore, Date dataInserimento, List<Prodotto> prodotti) {
        PacchettoProdotti nuovoPacchetto = new PacchettoProdotti(id, nome, descrizione, certificatiProdotto, costo, quantitativo, categoriaProdotto, idVenditore, dataInserimento, prodotti);
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
