package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.piattaforma_filiera_agricola.model.product.Prodotto;

import java.util.List;

@Repository
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
    List<Prodotto> findByStatoTrue(); //restituisce i prodotti verificati

    List<Prodotto> findByStatoFalse(); //restituisce i prodotti non verificati

    List<Prodotto> findByVenditoreIdAndStatoTrue(Long venditoreId);//restituisce i prodotti verificati di un venditore
}
