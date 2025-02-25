package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class PaginaEventi {
    private List<Evento> listaEventi = new ArrayList<>();

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public void setListaEventi(List<Evento> listaEventi) {
        this.listaEventi = listaEventi;
    }
}
