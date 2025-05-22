package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.model.user.Indirizzo;
import unicam.piattaforma_filiera_agricola.repository.EventoRepository;
import unicam.piattaforma_filiera_agricola.repository.ProdottoRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/map")
public class OsmController {

    private final ProdottoRepository prodottoRepository;
    private final EventoRepository eventoRepository;

    @Autowired
    public OsmController(ProdottoRepository prodottoRepository, EventoRepository eventoRepository) {
        this.prodottoRepository = prodottoRepository;
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/indirizzi")
    public ResponseEntity<Set<Indirizzo>> getAllIndirizzo() {
        Set<Indirizzo> indirizzi = new HashSet<>();
        //recupera e aggiunge gli indirizzi dei prodotti
        List<Prodotto> prodotti = this.prodottoRepository.findAll();
        for (Prodotto p : prodotti) {
            if (p.getIndirizzo() != null) {
                indirizzi.add(p.getIndirizzo());
            }
        }
        //recupera e aggiunge gli indirizzi degli eventi
        List<Evento> eventi = this.eventoRepository.findAll();
        for (Evento e : eventi) {
            if (e.getLuogo() != null) {
                indirizzi.add(e.getLuogo());
            }
        }
        return ResponseEntity.ok(indirizzi);
    }
}
