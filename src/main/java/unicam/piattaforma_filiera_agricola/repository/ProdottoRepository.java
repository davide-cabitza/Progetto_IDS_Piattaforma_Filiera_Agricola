package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
}
