package hu.nye.fitnessSite.felhasznalo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FelhasznaloRepository {
    List<Felhasznalo> user = new ArrayList<>();

    List<Felhasznalo> findAll(){
        return user;
    }

    Optional<Felhasznalo> findById(Long id){
        return user.stream().filter(felhasznalo -> felhasznalo.id() == id).findFirst();
    }

    void create(Felhasznalo felhasznalo){
        user.add(felhasznalo);
    }

    void update(Felhasznalo felhasznalo, Long id){
        Optional<Felhasznalo> existingFelh = findById(id);
        if (existingFelh.isPresent()){
            user.set(user.indexOf(existingFelh.get()), felhasznalo);
        }
    }

    void delete(Long id){
        user.removeIf(felhasznalo -> felhasznalo.id() == id);
    }
}
