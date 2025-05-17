package hu.nye.fitnessSite.kaloriaBevitel;

import hu.nye.fitnessSite.sulyEmeles.SulyEmeles;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface KaloriaBevitelRepository extends JpaRepository<KaloriaBevitel, Long> {
    List<KaloriaBevitel> findByFelhasznalo_Id(Long felhasznaloId);
}
