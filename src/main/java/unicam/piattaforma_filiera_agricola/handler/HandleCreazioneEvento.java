package unicam.piattaforma_filiera_agricola.handler;

import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class HandleCreazioneEvento {

    private final AnimatoreFiliera animatore;
    private final List<Evento> eventi;

    public HandleCreazioneEvento(AnimatoreFiliera animatore) {
        this.animatore = animatore;
        this.eventi = new ArrayList<>();
    }

    public Evento creaEvento(LocalDate dataInizio,
                             LocalDate dataFine,
                             String localita,
                             int maxPartecipanti,
                             String nome,
                             String descrizione) {
        String idEvento = UUID.randomUUID().toString();
        Evento evento = new Evento(idEvento, dataInizio, dataFine, localita, maxPartecipanti, nome, descrizione, animatore);
        eventi.add(evento);
        return evento;
    }

    public Evento modificaEvento(Evento evento,
                                 LocalDate dataInizio,
                                 LocalDate dataFine,
                                 String localita,
                                 int maxPartecipanti,
                                 String nome,
                                 String descrizione) {
        if (!eventi.contains(evento)) throw new IllegalArgumentException("Evento non gestito");
        evento.setDataInizio(dataInizio);
        evento.setDataFine(dataFine);
        evento.setLocalita(localita);
        evento.setMaxPartecipanti(maxPartecipanti);
        evento.setNome(nome);
        evento.setDescrizione(descrizione);
        return evento;
    }

    public void eliminaEvento(Evento evento) {
        if (!eventi.remove(evento)) throw new IllegalArgumentException("Evento non trovato");
    }

    public List<Evento> getEventiCreati() {
        return Collections.unmodifiableList(eventi);
    }

    public void eliminaTuttiEventi() {
        new ArrayList<>(eventi).forEach(this::eliminaEvento);
    }
}
