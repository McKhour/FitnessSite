package hu.nye.fitnessSite.kaloriaBevitel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class KaloriaServices {
    @Autowired
    private KaloriaBevitelRepository kaloraiRepo;

    public List<KaloriaBevitel> getAllKaloria(){
        return kaloraiRepo.findAll();
    }

    public KaloriaBevitel save(KaloriaBevitel kaloria){
        return kaloraiRepo.save(kaloria);
    }

    public KaloriaBevitel edit(KaloriaBevitel kaloria){
        return  kaloraiRepo.save(kaloria);
    }

    public KaloriaBevitel findById(Long id){
        Optional<KaloriaBevitel> optionalKaloria = kaloraiRepo.findById(id);
        if (optionalKaloria.isPresent()){
            return optionalKaloria.get();
        } else {
            throw new NoSuchElementException("Nem létezik kalória bevitel a következő ID-val: " + id);
        }
    }

    public void deleteById(Long id){
        kaloraiRepo.deleteById(id);
    }
}
