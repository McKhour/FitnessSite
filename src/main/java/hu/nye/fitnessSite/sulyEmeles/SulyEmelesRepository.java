package hu.nye.fitnessSite.sulyEmeles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SulyEmelesRepository extends JpaRepository<SulyEmeles, Long> {
    List<SulyEmeles> findByFelhasznalo_Id(Long felhasznaloId);
}
