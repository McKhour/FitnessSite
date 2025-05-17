package hu.nye.fitnessSite.sulyEmeles;

import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitel;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface SulyEmelesRepository extends JpaRepository<SulyEmeles, Long> {
    List<SulyEmeles> findByFelhasznalo_Id(Long felhasznaloId);
}
