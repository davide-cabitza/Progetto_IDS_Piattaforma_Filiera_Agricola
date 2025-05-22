package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerAnimatore;
import unicam.piattaforma_filiera_agricola.handler.HandlerNotifica;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.repository.AnimatoreRepository;
import unicam.piattaforma_filiera_agricola.repository.EventoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/animatori")
public class AnimatoreController {
    private final AnimatoreRepository animatoreRepository;
    private final EventoRepository eventoRepository;
    private final HandlerNotifica notificaService;
    private final HandlerAnimatore handlerAnimatore;

    @Autowired
    public AnimatoreController(AnimatoreRepository animatoreRepository, EventoRepository eventoRepository, HandlerNotifica notificaService, HandlerAnimatore handlerAnimatore) {
        this.animatoreRepository = animatoreRepository;
        this.eventoRepository = eventoRepository;
        this.notificaService = notificaService;
        this.handlerAnimatore = handlerAnimatore;
    }

    @PostMapping
    public ResponseEntity<AnimatoreFiliera> createAnimatore (@RequestBody AnimatoreFiliera animatoreFiliera) {
        AnimatoreFiliera saved = animatoreRepository.save(animatoreFiliera);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<AnimatoreFiliera>> getAllAnimatori() {
        List<AnimatoreFiliera> animatori = this.animatoreRepository.findAll();
        return ResponseEntity.ok(animatori);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimatoreFiliera> getAnimatoreById(@PathVariable Long id) {
        return animatoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crea un evento per un animatore e notifica i subscriber.
     *
     * @param animatoreId ID dell'animatore
     * @param evento      l'evento da creare
     * @return ResponseEntity contenente l'evento creato
     */
    @PostMapping("/{animatoreId}/eventi")
    public ResponseEntity<Evento> createEvento(@PathVariable Long animatoreId, @RequestBody Evento evento) {
        AnimatoreFiliera animatore = animatoreRepository.findById(animatoreId)
                .orElseThrow(() -> new RuntimeException("Animatore non trovato con id: " + animatoreId));
        Evento eventoCreato = handlerAnimatore.creaEvento(animatoreId, evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoCreato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimatoreFiliera> updateAnimatore(@PathVariable Long id, @RequestBody AnimatoreFiliera animatoreData) {
        return animatoreRepository.findById(id)
                .map(existing -> {
                    existing.setNome(animatoreData.getNome());
                    // Se ci sono altri campi da aggiornare, gestiscili qui
                    AnimatoreFiliera updated = animatoreRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimatore(@PathVariable Long id) {
        if (animatoreRepository.existsById(id)) {
            animatoreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
