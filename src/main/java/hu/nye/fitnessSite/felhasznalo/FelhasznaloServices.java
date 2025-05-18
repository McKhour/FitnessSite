package hu.nye.fitnessSite.felhasznalo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

//itt található minden metódus
@Service
public class FelhasznaloServices {

    @Autowired
    private FelhasznaloRepository felhasznaloRepo;

    public List<Felhasznalo> getAllFelhaszn(){
        return felhasznaloRepo.findAll();
    }

    public Felhasznalo save(Felhasznalo felhasznalo){
        return felhasznaloRepo.save(felhasznalo);
    }

    public Felhasznalo edit(Felhasznalo felhasznalo){
        return felhasznaloRepo.save(felhasznalo);
    }

    public Felhasznalo findById(Long id){
        Optional<Felhasznalo> optionalFelhasznalo = felhasznaloRepo.findById(id);
        if (optionalFelhasznalo.isPresent()){
            return optionalFelhasznalo.get();
        } else {
            throw new NoSuchElementException("Nem létezik felhasználó a következő id-val: " + id);
        }
    }

    public void deleteById(Long id){
        felhasznaloRepo.deleteById(id);
    }
}
