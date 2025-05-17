package hu.nye.fitnessSite.futas;

import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface FutasRepository extends JpaRepository<Futas, Long> {
    List<Futas> findByFelhasznalo_Id(Long felhasznaloId);
}
