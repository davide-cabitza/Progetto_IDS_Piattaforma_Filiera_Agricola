package unicam.piattaforma_filiera_agricola.seller;

import unicam.piattaforma_filiera_agricola.product.PacchettoProdotti;
import unicam.piattaforma_filiera_agricola.product.Prodotto;

import java.util.Date;
import java.util.List;

public class Distributore extends Venditore implements ISeller {

    private List<PacchettoProdotti> listaPacchetti;



    public Distributore(int id, String nome, String email, int numeroTelefono, String indirizzo, String NomeUtente, String partitaIva,
                        List<Prodotto> listaProdotti, String certificatiProdotto, String certificatiAzienda, List<PacchettoProdotti> listaPacchetti) {

        super(id, nome, email, numeroTelefono, indirizzo, NomeUtente, partitaIva, listaProdotti, certificatiProdotto, certificatiAzienda);
        this.listaPacchetti = listaPacchetti;
    }


    @Override
    public Prodotto creaProdotto(int id, String nome, String descrizione, String certificatiProdotto, Float costo, int quantitativo, String categoriaProdotto, int idVenditore, Date dataInserimento) {
        return null;
    }


    public void aggiungiProdottoAlPacchetto(PacchettoProdotti pacchetto, Prodotto prodotto) {
        pacchetto.aggiungiProdotto(prodotto);
    }

    // Metodo per ottenere la lista di pacchetti creati dal distributore
    public List<PacchettoProdotti> getListaPacchetti() {
        return listaPacchetti;
    }


    @Override
    public void caricaProdotto(Prodotto p) {

    }

    @Override
    public void modifyProdotto(Prodotto p) {

    }
}
