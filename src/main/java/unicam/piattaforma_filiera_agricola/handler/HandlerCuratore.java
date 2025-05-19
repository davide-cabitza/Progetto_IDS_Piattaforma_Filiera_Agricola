package unicam.piattaforma_filiera_agricola.handler;

import org.springframework.stereotype.Service;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import unicam.piattaforma_filiera_agricola.repository.ProdottoRepository;

import java.util.List;

@Service
public class HandlerCuratore {

    private final ProdottoRepository prodottoRepository;

    public HandlerCuratore(ProdottoRepository prodottoRepository) {
        this.prodottoRepository = prodottoRepository;
    }

    public List<Prodotto> getListaProdotti() {
        return prodottoRepository.findByStatoFalse();
    }

    public Prodotto verifyProduct(Long productId) {
        Prodotto product = prodottoRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato con id: " + productId));
        product.setStato(true);
        return prodottoRepository.save(product);
    }

    public List<Prodotto> getVerifiedProductsByVendor(Long venditoreId) {
        return prodottoRepository.findByVenditoreIdAndStatoTrue(venditoreId);
    }

}
