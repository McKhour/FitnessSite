package hu.nye.fitnessSite.sulyEmeles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SulyServices {
    @Autowired
    private SulyEmelesRepository sulyRepo;

    public List<SulyEmeles> getAllSuly(){
        return sulyRepo.findAll();
    }

    public SulyEmeles save(SulyEmeles suly){
        return sulyRepo.save(suly);
    }

    public SulyEmeles edit(SulyEmeles suly){
        return sulyRepo.save(suly);
    }

    public SulyEmeles findById(Long id){
        Optional<SulyEmeles> optionalSuly = sulyRepo.findById(id);
        if (optionalSuly.isPresent()){
            return optionalSuly.get();
        }else {
            throw new NoSuchElementException("Nem létezik súly emelés a következő ID-val: " + id);
        }
    }
    public void deleteById(Long id){
        sulyRepo.deleteById(id);
    }
}
