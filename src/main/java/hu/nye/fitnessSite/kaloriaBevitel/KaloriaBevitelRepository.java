package hu.nye.fitnessSite.kaloriaBevitel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KaloriaBevitelRepository extends JpaRepository<KaloriaBevitel, Long> {
    List<KaloriaBevitel> findByFelhasznalo_Id(Long felhasznaloId);
}
