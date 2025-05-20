package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.piattaforma_filiera_agricola.model.user.Notifica;

import java.util.List;

@Repository
public interface NotificaRepository extends JpaRepository<Notifica, Long> {
    List<Notifica> findByUtenteId(Long utenteId);
}
