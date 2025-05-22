package unicam.piattaforma_filiera_agricola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unicam.piattaforma_filiera_agricola.handler.HandlerAcquirente;
import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;
import unicam.piattaforma_filiera_agricola.model.payment.Pagamento;

@RestController
@RequestMapping("/api/acquirenti")
public class CarrelloController {

    private final HandlerAcquirente handlerAcquirente;

    @Autowired
    public CarrelloController(HandlerAcquirente handlerAcquirente) {
        this.handlerAcquirente = handlerAcquirente;
    }

    @PostMapping("/{id}/cart/add")
    public ResponseEntity<Void> addProductToCart(@PathVariable Long id,
                                                 @RequestParam Long productId) {
        this.handlerAcquirente.addProduct(productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/cart/remove")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long id,
                                                      @RequestParam Long productId) {
        this.handlerAcquirente.removeProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/cart")
    public ResponseEntity<Carrello> getCart(@PathVariable Long id) {
        Carrello cart = this.handlerAcquirente.getShoppingCart();
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/{id}/cart/pay")
    public ResponseEntity<String> payCart(@PathVariable Long id) {
        Pagamento pagamento = this.handlerAcquirente.pay(null);
        if (pagamento == null || pagamento.getRicevuta() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Pagamento fallito");
        }
        return ResponseEntity.ok(pagamento.getRicevuta().getDescrizione());
    }

}
