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

    Optional<Futas> findById(Long id){
        return fut.stream().filter(futas -> futas.id() == id).findFirst();
    }

    void create(Futas futas){
        fut.add(futas);
    }

    void update(Futas futas, Long id){
        Optional<Futas> existingFutas = findById(id);
        if (existingFutas.isPresent()){
            fut.set(fut.indexOf(existingFutas.get()),futas);
        }
    }

    void delete(Long id){
        fut.removeIf(futas -> futas.id().equals(id));
    }

}
