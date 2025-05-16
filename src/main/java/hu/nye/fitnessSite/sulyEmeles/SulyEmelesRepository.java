package hu.nye.fitnessSite.sulyEmeles;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SulyEmelesRepository {
    List<SulyEmeles> suly = new ArrayList<>();

    List<SulyEmeles> findAll(){
        return suly;
    }

    Optional<SulyEmeles> findById(Integer id){
        return suly.stream().filter(sulyEmeles -> sulyEmeles.id() == id).findFirst();
    }

    void create(SulyEmeles sulyEmeles){
        suly.add(sulyEmeles);
    }

    void update(SulyEmeles sulyEmeles, Integer id){
        Optional<SulyEmeles> existingSuly = findById(id);
        if (existingSuly.isPresent()) {
            suly.set(suly.indexOf(existingSuly.get()), sulyEmeles);
        }
    }

    void delete(Integer id){
        suly.removeIf(sulyEmeles -> sulyEmeles.id() == id);
    }

    @PostConstruct
    private void init(){
        suly.add(new SulyEmeles(
                1,
                1,
                50,
                15,
                10,
                Tipusa.TOLOPAD
        ));

        suly.add(new SulyEmeles(
                2,
                1,
                75,
                10,
                15,
                Tipusa.FEKVENYOMAS
        ));
    }
}
