package hu.nye.fitnessSite.futas;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FutasRepository {

    private List<Futas> fut = new ArrayList<>();

    List<Futas> findAll(){
        return fut;
    }

    Optional<Futas> findById(Integer id){
        return fut.stream().filter(futas -> futas.id() == id).findFirst();
    }

    void create(Futas futas){
        fut.add(futas);
    }

    void update(Futas futas, Integer id){
        Optional<Futas> existingFutas = findById(id);
        if (existingFutas.isPresent()){
            fut.set(fut.indexOf(existingFutas.get()),futas);
        }
    }

    void delete(Integer id){
        fut.removeIf(futas -> futas.id().equals(id));
    }
    @PostConstruct
    private void init(){
        fut.add(new Futas( 1,
                1,
            "Hétfő Reggeli",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                0.7,
                Helye.KINT
        ));

        fut.add(new Futas( 2,
                1,
                "Hétfő Délutáni",
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(25),
                1.3,
                Helye.KINT
        ));
    }
}
