package unicam.piattaforma_filiera_agricola.model.platform;

import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce gli eventi disponibili nella piattaforma.
 * Singleton che mantiene la lista degli eventi e aggiorna la mappa.
 */
public class PaginaEventi {

    private List<Evento> eventInPlatform;
    private static PaginaEventi instance;

    private PaginaEventi() {
        this.eventInPlatform = new ArrayList<>();
    }

    public static synchronized PaginaEventi getInstance() {
        if (instance == null) {
            instance = new PaginaEventi();
        }
        return instance;
    }

    public List<Evento> getEventInPlatform() {
        return eventInPlatform;
    }

    public void setEventInPlatform(List<Evento> eventInPlatform) {
        this.eventInPlatform = eventInPlatform;
    }



    public void removeEventById(Long id) {
        eventInPlatform.removeIf(evt -> evt.getIdEvento().equals(id));
    }

    public Evento getEventById(Long id) {
        return eventInPlatform.stream()
                .filter(evt -> evt.getIdEvento().equals(id))
                .findFirst()
                .orElse(null);
    }
}
