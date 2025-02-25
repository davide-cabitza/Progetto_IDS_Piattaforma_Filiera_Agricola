package unicam.piattaforma_filiera_agricola;

import java.util.Date;

public interface Ivenditore {
    void caricaPrdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data,CategoriaProdotto categoriaProdotto,Certificati certificatiProdotto);
}
