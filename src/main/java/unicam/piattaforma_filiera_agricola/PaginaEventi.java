package unicam.piattaforma_filiera_agricola;

import java.util.ArrayList;
import java.util.List;

public class PaginaEventi {
    private List<Evento> listaEventi = new ArrayList<>();
    private boolean stato;

    public PaginaEventi(List<Evento> lista, boolean stato) {
        this.stato = stato;
        this.listaEventi = lista;
    }

    public Evento cercaEvento(String prod) {
        List<Evento> risultati = new ArrayList<>();
        for (Evento e : this.listaEventi) {
            if (e.getNomeEvento().equalsIgnoreCase(prod)) { // Confronto case-insensitive
                risultati.add(e);
            }
        }
        return risultati.getFirst();
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    private void setListaEventi(List<Evento> listaE) {
        this.listaEventi = listaE;
    }

    public boolean isStato() {
        return stato;
    }

    private void setStato(boolean stato) {
        this.stato = stato;
    }
}
