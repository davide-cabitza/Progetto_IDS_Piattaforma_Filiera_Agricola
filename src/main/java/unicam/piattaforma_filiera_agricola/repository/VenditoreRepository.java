package unicam.piattaforma_filiera_agricola.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import unicam.piattaforma_filiera_agricola.model.seller.Venditore;

@Repository
public interface VenditoreRepository extends JpaRepository<Venditore, Long>{
}
