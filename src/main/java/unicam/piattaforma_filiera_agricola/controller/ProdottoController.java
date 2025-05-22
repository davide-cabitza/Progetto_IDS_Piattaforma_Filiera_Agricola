package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerVenditore;
import unicam.piattaforma_filiera_agricola.model.product.Pacchetto;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.repository.ProdottoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoController {

    private final HandlerVenditore venditoreService;
    private final ProdottoRepository prodottoRepository;

    @Autowired
    public ProdottoController(HandlerVenditore venditoreService, ProdottoRepository prodottoRepository) {
        this.venditoreService = venditoreService;
        this.prodottoRepository = prodottoRepository;
    }

    @PostMapping
    public ResponseEntity<Prodotto> createProdotto(@RequestBody Prodotto prodotto) {
        if(prodotto.getVenditore() == null || prodotto.getVenditore().getId() == null || prodotto.getIndirizzo() == null)  {
            return ResponseEntity.badRequest().build();
        }

        // Recupera venditore completo dal DB
        var venditoreId = venditoreService.findVenditoreById(prodotto.getVenditore().getId());
        if (venditoreId.isEmpty()) {
            return ResponseEntity.badRequest().build();  // O anche ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Prodotto prodottoCreato = venditoreService.createProduct(
                venditoreId.get(),
                prodotto.getNomeProdotto(),
                prodotto.getCosto(),
                prodotto.getDescrizione(),
                prodotto.getIndirizzo()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(prodottoCreato);
    }

    @GetMapping
    public ResponseEntity<List<Prodotto>> getAllProdottos() {

        List<Prodotto> prodotti = prodottoRepository.findByStatoTrue();
        return ResponseEntity.ok(prodotti);
    }

    @GetMapping("/venditore/{venditoreId}")
    public ResponseEntity<List<Prodotto>> getProdottoByVenditore(@PathVariable Long venditoreId) {
        List<Prodotto> prodotti = prodottoRepository.findByVenditoreIdAndStatoTrue(venditoreId);
        return ResponseEntity.ok(prodotti);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prodotto> getProdottoById(@PathVariable Long id) {
        return prodottoRepository.findById(id)
                .filter(Prodotto::isStato)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prodotto> updateProdotto(@PathVariable Long id, @RequestBody Prodotto prodottoData) {
        Prodotto updatedProdotto = venditoreService.updateProdotto(id, prodottoData);
        return ResponseEntity.ok(updatedProdotto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdotto(@PathVariable Long id) {
        if (prodottoRepository.existsById(id)) {
            prodottoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/pacchetto")
    public ResponseEntity<Pacchetto> creaPacchetto(@RequestBody Pacchetto pacchettoRequest) {

        System.out.println("Ricevuto pacchetto: " + pacchettoRequest);
        // 1. Validazione minima
        if (pacchettoRequest.getVenditore() == null || pacchettoRequest.getVenditore().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        // 2. Carica venditore completo da DB
        var venditoreOpt = venditoreService.findVenditoreById(pacchettoRequest.getVenditore().getId());
        if (venditoreOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        pacchettoRequest.setVenditore(venditoreOpt.get());

        // 3. Per ogni prodotto in pacchettoRequest.pacchetto, carica il prodotto completo da DB
        List<Prodotto> prodottiCompleti = pacchettoRequest.getPacchetto().stream()
                .map(prodotto -> venditoreService.getProdottoById(prodotto.getId()))
                .filter(p -> p != null)
                .toList();

        pacchettoRequest.setPacchetto(prodottiCompleti);

        // 4. Calcola costo totale (meglio farlo in service)
        double costoTotale = prodottiCompleti.stream().mapToDouble(Prodotto::getCosto).sum();
        pacchettoRequest.setCosto(costoTotale);

        // 5. Salva il pacchetto
        Pacchetto pacchettoCreato = venditoreService.creaPacchetto(pacchettoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacchettoCreato);
    }


}
