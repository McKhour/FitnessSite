package hu.nye.fitnessSite.futas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FutasRepository extends JpaRepository<Futas, Long> {
    List<Futas> findByFelhasznalo_Id(Long felhasznaloId);
}
