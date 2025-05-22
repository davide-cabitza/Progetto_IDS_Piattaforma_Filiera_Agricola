package unicam.piattaforma_filiera_agricola.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerNotifica;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.repository.AnimatoreRepository;
import unicam.piattaforma_filiera_agricola.repository.EventoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/eventi")
public class EventoController {

    private final EventoRepository eventoRepository;
    private final AnimatoreRepository animatoreRepository;
    private final HandlerNotifica notificaService;

    @Autowired
    public EventoController(EventoRepository eventoRepository,
                            AnimatoreRepository animatoreRepository,
                            HandlerNotifica notificaService) {
        this.eventoRepository = eventoRepository;
        this.animatoreRepository = animatoreRepository;
        this.notificaService = notificaService;
    }

    /*
    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
        // Verifica che l'evento contenga un creatore (animatore) valido
        if (evento.getCreatore() == null || evento.getCreatore().getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        AnimatoreFiliera animatore = this.animatoreRepository.findById(evento.getCreatore().getId())
                .orElseThrow(() -> new RuntimeException("Animatore non trovato con id: " + evento.getCreatore().getId()));
        evento.setCreatore(animatore);
        animatore.creaEvento(evento.getNome(), evento.getDescrizione(), evento.getMaxPartecipanti(), evento.getLuogo(), evento.getDataFine(), this.notificaService);
        this.animatoreRepository.save(animatore);
        List<Evento> eventi = animatore.getEventoCreato();
        Evento savedEvento = eventi.get(eventi.size() - 1);
        this.eventoRepository.save(savedEvento);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvento);
    }
    */

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventi() {
        List<Evento> eventi = eventoRepository.findAll();
        return ResponseEntity.ok(eventi);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> updateEvento(@PathVariable Long id, @RequestBody Evento eventoData) {
        return eventoRepository.findById(id)
                .map(existing -> {
                    existing.setNome(eventoData.getNome());
                    existing.setDescrizione(eventoData.getDescrizione());
                    existing.setMaxPartecipanti(eventoData.getMaxPartecipanti());
                    existing.setLuogo(eventoData.getLuogo());
                    // Il campo creator non viene modificato
                    Evento updated = eventoRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        return eventoRepository.findById(id)
                .<ResponseEntity<Void>>map(evento -> {
                    // 1. Dissocia l'evento dall'animatore, se necessario
                    AnimatoreFiliera animatore = evento.getCreatore();
                    if (animatore != null) {
                        animatore.getEventoCreato().remove(evento);
                        animatoreRepository.save(animatore);
                    }
                    // 2. Elimina l'evento
                    eventoRepository.delete(evento);
                    // 3. Restituisce 204 No Content
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
