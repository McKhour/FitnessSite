package hu.nye.fitnessSite.futas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FutasServices {
    @Autowired
    private FutasRepository futasRepo;

    public List<Futas> getAllFutas(){
        return futasRepo.findAll();
    }

    public Futas save(Futas futas){
        return futasRepo.save(futas);
    }

    public Futas edit(Futas futas){
        return futasRepo.save(futas);
    }

    public Futas findById(Long id){
        Optional<Futas> optionalFutas =futasRepo.findById(id);
        if (optionalFutas.isPresent()){
            return optionalFutas.get();
        } else {
            throw new NoSuchElementException("Nem létezik futás a következő ID-val: " +id);
        }
    }

    public void deleteById(Long id){
        futasRepo.deleteById(id);
    }
}
