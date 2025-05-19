package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerCuratore;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

@RestController
@RequestMapping("/api/curatori")
public class CuratoreController {

    private final HandlerCuratore curatoreService;

    public CuratoreController(HandlerCuratore handlerCuratore) {
        this.curatoreService = handlerCuratore;
    }

    @GetMapping("/prodotti/lista")
    public ResponseEntity<List<Prodotto>> getListaProducts() {
        List<Prodotto> lista = this.curatoreService.getListaProdotti();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/verify/{productId}")
    public ResponseEntity<Prodotto> verifyProduct(@PathVariable Long productId) {
        Prodotto verified = this.curatoreService.verifyProduct(productId);
        return ResponseEntity.ok(verified);
    }

    @GetMapping("/prodotti/venditore/{venditoreID}")
    public ResponseEntity<List<Prodotto>> getVerifiedProductsByVendor(@PathVariable Long venditoreID) {
        List<Prodotto> prodotti = this.curatoreService.getVerifiedProductsByVendor(venditoreID);
        return ResponseEntity.ok(prodotti);
    }

}
