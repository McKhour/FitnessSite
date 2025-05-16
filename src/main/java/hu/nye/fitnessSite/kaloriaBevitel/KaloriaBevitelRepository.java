package hu.nye.fitnessSite.kaloriaBevitel;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class KaloriaBevitelRepository {
    private List<KaloriaBevitel> bevitel = new ArrayList<>();
    List<KaloriaBevitel> findAll()
    {
        return bevitel;

    }

    Optional<KaloriaBevitel> findById(Long id){
        return bevitel.stream().filter(kaloriaBevitel -> kaloriaBevitel.id() == id).findFirst();
    }

    void create(KaloriaBevitel kaloriaBevitel){
        bevitel.add(kaloriaBevitel);
    }

    void update(KaloriaBevitel kaloriaBevitel, Long id){
        Optional<KaloriaBevitel> existingBevitel = findById(id);
        if (existingBevitel.isPresent()){
            bevitel.add(bevitel.indexOf(existingBevitel.get()),kaloriaBevitel);
        }
    }

    void delete(Long id)
    {
        bevitel.removeIf(kaloriaBevitel -> kaloriaBevitel.id() == id);

    }

}
