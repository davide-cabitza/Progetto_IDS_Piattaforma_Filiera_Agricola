package unicam.piattaforma_filiera_agricola.model.platform;

import unicam.piattaforma_filiera_agricola.model.product.Prodotto;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestisce i prodotti disponibili nella piattaforma.
 * Singleton che mantiene la lista dei prodotti e aggiorna la mappa.
 */
public class Marketplace {

    private List<Prodotto> productInPlatform;
    private static Marketplace instance;

    private Marketplace() {
        this.productInPlatform = new ArrayList<>();
    }

    public static synchronized Marketplace getInstance() {
        if (instance == null) {
            instance = new Marketplace();
        }
        return instance;
    }

    public List<Prodotto> getProductInPlatform() {
        return productInPlatform;
    }

    public void setProductInPlatform(List<Prodotto> productInPlatform) {
        this.productInPlatform = productInPlatform;
    }



    public void removeProductById(Long id) {
        productInPlatform.removeIf(prod -> prod.getId() == (id));
    }

    public Prodotto getProductById(Long id) {
        return productInPlatform.stream()
                .filter(prod -> prod.getId() == (id))
                .findFirst()
                .orElse(null);
    }
}
