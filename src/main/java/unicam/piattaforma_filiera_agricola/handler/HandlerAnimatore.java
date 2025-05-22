package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.repository.AnimatoreRepository;
import unicam.piattaforma_filiera_agricola.repository.EventoRepository;
import unicam.piattaforma_filiera_agricola.repository.UtenteRepository;
import unicam.piattaforma_filiera_agricola.repository.VenditoreRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Service per la gestione degli animatori della filiera, delle iscrizioni e degli eventi da loro creati.
 */
@Service
public class HandlerAnimatore {

    private final AnimatoreRepository animatoreRepository;
    private final HandlerNotifica notificaService;
    private final EventoRepository eventoRepository;
    private final VenditoreRepository venditoriRepository;
    //private final UtenteRepository utenteRepository;

    @Autowired
    public HandlerAnimatore(AnimatoreRepository animatoreRepository, HandlerNotifica notificaService, EventoRepository eventoRepository, VenditoreRepository venditoriRepository/*, UtenteRepository utenteRepository*/) {
        this.animatoreRepository = animatoreRepository;
        this.notificaService = notificaService;
        //this.utenteRepository = utenteRepository;
        this.eventoRepository = eventoRepository;
        this.venditoriRepository = venditoriRepository;
    }

    public Evento creaEvento(Long animatoreId, Evento eventoInput) {
        AnimatoreFiliera animatore = animatoreRepository.findById(animatoreId)
                .orElseThrow(() -> new RuntimeException("Animatore non trovato con id: " + animatoreId));

        // Recupera gli ID dei venditori dal JSON (servono id in venditoriInvitati)
        List<Venditore> venditori = new ArrayList<>();
        if (eventoInput.getVenditoriInvitati() != null && !eventoInput.getVenditoriInvitati().isEmpty()) {
            List<Long> ids = eventoInput.getVenditoriInvitati()
                    .stream()
                    .map(Venditore::getId)
                    .toList();
            venditori = venditoriRepository.findAllById(ids);
        }

        Evento evento = new Evento(
                eventoInput.getNome(),
                eventoInput.getDescrizione(),
                eventoInput.getMaxPartecipanti(),
                eventoInput.getLuogo(),
                animatore,
                eventoInput.getDataFine(),
                venditori
        );

        evento = eventoRepository.save(evento);
        animatore.getEventoCreato().add(evento); // se serve per logica interna
        animatoreRepository.save(animatore); // salva eventuali modifiche all’animatore (non obbligatorio se non cambia)

        return evento;
    }

}
