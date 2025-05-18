package hu.nye.fitnessSite.felhasznalo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//sokat nem kell bele írni, így csak ennyi
@Repository
public interface FelhasznaloRepository extends JpaRepository<Felhasznalo, Long> {

}
