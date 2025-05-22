package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.piattaforma_filiera_agricola.model.buyer.Acquirente;

@Repository
public interface AcquirenteRepository extends JpaRepository<Acquirente, Long> {
}
