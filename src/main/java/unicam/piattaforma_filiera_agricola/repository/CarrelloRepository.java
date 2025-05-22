package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.piattaforma_filiera_agricola.model.buyer.Carrello;

@Repository
public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}
