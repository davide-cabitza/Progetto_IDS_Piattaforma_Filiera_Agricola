package unicam.piattaforma_filiera_agricola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unicam.piattaforma_filiera_agricola.model.animatore.AnimatoreFiliera;

@Repository
public interface AnimatoreRepository extends JpaRepository<AnimatoreFiliera, Long> {

}
