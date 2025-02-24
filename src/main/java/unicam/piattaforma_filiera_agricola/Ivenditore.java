package unicam.piattaforma_filiera_agricola;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public interface Ivenditore {
    void caricaPrdotto(String id, String nome, String descrizione, Float costo, int quantitativo, Date data);
}
