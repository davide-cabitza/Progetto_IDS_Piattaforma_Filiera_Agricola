package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unicam.piattaforma_filiera_agricola.model.animatore.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
