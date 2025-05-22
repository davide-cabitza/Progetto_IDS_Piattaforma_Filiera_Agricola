package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.model.buyer.Acquirente;
import unicam.piattaforma_filiera_agricola.repository.AcquirenteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/acquirenti")
public class AcquirenteController {

    private final AcquirenteRepository acquirenteRepository;

    @Autowired
    public AcquirenteController(AcquirenteRepository acquirenteRepository) {
        this.acquirenteRepository = acquirenteRepository;
    }

    @PostMapping
    public ResponseEntity<Acquirente> createAcquirente(@RequestBody Acquirente acquirente) {
        Acquirente saved = this.acquirenteRepository.save(acquirente);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acquirente> getAcquirente(@PathVariable Long id) {
        Optional<Acquirente> acquirente = this.acquirenteRepository.findById(id);
        return acquirente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acquirente> updateAcquirente(@PathVariable Long id, @RequestBody Acquirente acquirenteData) {
        return this.acquirenteRepository.findById(id)
                .map(existing -> {
                    existing.setNome(acquirenteData.getNome());
                    existing.setEmail(acquirenteData.getEmail());
                    existing.setPassword(acquirenteData.getPassword());
                    Acquirente updated = this.acquirenteRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcquirente(@PathVariable Long id) {
        if (this.acquirenteRepository.existsById(id)) {
            this.acquirenteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Acquirente>> getAllAcquirenti() {
        List<Acquirente> acquirenti = acquirenteRepository.findAll();
        return ResponseEntity.ok(acquirenti);
    }



}
