package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.piattaforma_filiera_agricola.Carrello;

public interface CarrelloRepository extends JpaRepository<Carrello, Long> {
}
