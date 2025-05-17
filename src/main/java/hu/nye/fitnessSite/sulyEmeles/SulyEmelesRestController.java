package hu.nye.fitnessSite.sulyEmeles;

import hu.nye.fitnessSite.kaloriaBevitel.KaloriaBevitel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sulyEmeles")
public class SulyEmelesRestController {

    private final SulyEmelesRepository sulyEmelesRepository;

    public SulyEmelesRestController(SulyEmelesRepository sulyEmelesRepository) {
        this.sulyEmelesRepository = sulyEmelesRepository;
    }

    @GetMapping("")
    List<SulyEmeles> findAll(){
        return sulyEmelesRepository.findAll();
    }

    @GetMapping("/{id}")
    SulyEmeles findById(@PathVariable Long id){
        Optional<SulyEmeles> suly = sulyEmelesRepository.findById(id);
        if (suly.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem található ilyen bejegyzés");
        }
        return suly.get();
    }

    public List<SulyEmeles> findByUId(@PathVariable Long felhasznaloId){
        List<SulyEmeles> suly = sulyEmelesRepository.findByFelhasznalo_Id(felhasznaloId);
        if (suly.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem található ilyen bejegyzés");
        }
        return suly;
    }

    //post
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody SulyEmeles suly){
        sulyEmelesRepository.save(suly);
    }

    //put
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void put(@Valid @RequestBody SulyEmeles suly, @PathVariable Long id){
        Optional<SulyEmeles> optionalExisting = sulyEmelesRepository.findById(id);
        if (optionalExisting.isPresent()){
            SulyEmeles existing = optionalExisting.get();
            if (suly.getFelhasznalo() != null){
                existing.setFelhasznalo(suly.getFelhasznalo());
            }
            if (suly.getSuly() != null){
                existing.setSuly(suly.getSuly());
            }
            if (suly.getSzettek() != null){
                existing.setSzettek(suly.getSzettek());
            }
            if (suly.getRepek() != null){
                existing.setRepek(suly.getRepek());
            }
            if (suly.getTipusa() != null){
                existing.setTipusa(suly.getTipusa());
            }
            sulyEmelesRepository.save(existing);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem létezik ilyen bejegyzés");
        }
    }
    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@Valid @RequestBody @PathVariable Long id){
        if (!sulyEmelesRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Nem található ilyen bejegyzés");
        }
        sulyEmelesRepository.deleteById(id);
    }
}
