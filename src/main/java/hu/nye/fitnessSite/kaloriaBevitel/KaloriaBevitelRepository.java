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

    Optional<KaloriaBevitel> findById(Integer id){
        return bevitel.stream().filter(kaloriaBevitel -> kaloriaBevitel.id() == id).findFirst();
    }

    void create(KaloriaBevitel kaloriaBevitel){
        bevitel.add(kaloriaBevitel);
    }

    void update(KaloriaBevitel kaloriaBevitel, Integer id){
        Optional<KaloriaBevitel> existingBevitel = findById(id);
        if (existingBevitel.isPresent()){
            bevitel.add(bevitel.indexOf(existingBevitel.get()),kaloriaBevitel);
        }
    }

    void delete(Integer id)
    {
        bevitel.removeIf(kaloriaBevitel -> kaloriaBevitel.id() == id);

    }

    @PostConstruct
    private void init(){
        bevitel.add(new KaloriaBevitel(
                1,
                12,
                31,
                35,
                120
                ));

        bevitel.add(new KaloriaBevitel(
                1,
                13,
                134,
                54,
                130
        ));
    }
}
