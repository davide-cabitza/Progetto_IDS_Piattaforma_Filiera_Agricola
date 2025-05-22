package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerVenditore;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;
import unicam.piattaforma_filiera_agricola.repository.VenditoreRepository;

import java.util.List;

@RestController
@RequestMapping("/api/venditori")
public class VenditoreController {
    private final VenditoreRepository venditoreRepository;

    @Autowired
    public VenditoreController(VenditoreRepository venditoreRepository) {
        this.venditoreRepository = venditoreRepository;
    }

    @PostMapping
    public ResponseEntity<Venditore> createVenditore (@RequestBody Venditore venditore) {
        Venditore saved = venditoreRepository.save(venditore);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Venditore>> getAllVenditori () {
        List<Venditore> venditori = venditoreRepository.findAll();
        return ResponseEntity.ok(venditori);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venditore> getVenditoreById (@PathVariable Long id) {
        return venditoreRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venditore> updateVenditore(@PathVariable Long id, @RequestBody Venditore venditoreData) {
        return  venditoreRepository.findById(id)
                .map(existing -> {
                    existing.setNome(venditoreData.getNome());
                    existing.setIndirizzo(venditoreData.getIndirizzo());

                    Venditore updated = venditoreRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVenditore(@PathVariable Long id) {
        if (venditoreRepository.existsById(id)) {
            venditoreRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
