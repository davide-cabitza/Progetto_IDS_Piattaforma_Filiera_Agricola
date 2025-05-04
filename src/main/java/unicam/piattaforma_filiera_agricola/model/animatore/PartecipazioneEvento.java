package unicam.piattaforma_filiera_agricola.model.animatore;

import unicam.piattaforma_filiera_agricola.model.seller.UtenteLoggato;

import java.time.LocalDateTime;

public class PartecipazioneEvento {
    private final String idPartecipazione;
    private final Evento evento;
    private final UtenteLoggato partecipante;
    private final LocalDateTime dataIscrizione;

    public PartecipazioneEvento(String idPartecipazione,
                                Evento evento,
                                UtenteLoggato partecipante,
                                LocalDateTime dataIscrizione) {
        this.idPartecipazione = idPartecipazione;
        this.evento = evento;
        this.partecipante = partecipante;
        this.dataIscrizione = dataIscrizione;
    }
    public String getIdPartecipazione() { return idPartecipazione; }
    public Evento getEvento() { return evento; }
    public UtenteLoggato getPartecipante() { return partecipante; }
    public LocalDateTime getDataIscrizione() { return dataIscrizione; }
}
