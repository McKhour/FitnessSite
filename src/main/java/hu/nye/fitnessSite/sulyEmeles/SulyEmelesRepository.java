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

    Optional<SulyEmeles> findById(Long id){
        return suly.stream().filter(sulyEmeles -> sulyEmeles.id() == id).findFirst();
    }

    void create(SulyEmeles sulyEmeles){
        suly.add(sulyEmeles);
    }

    void update(SulyEmeles sulyEmeles, Long id){
        Optional<SulyEmeles> existingSuly = findById(id);
        if (existingSuly.isPresent()) {
            suly.set(suly.indexOf(existingSuly.get()), sulyEmeles);
        }
    }

    void delete(Long id){
        suly.removeIf(sulyEmeles -> sulyEmeles.id() == id);
    }
}
