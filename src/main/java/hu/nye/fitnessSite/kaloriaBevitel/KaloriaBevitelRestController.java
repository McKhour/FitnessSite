package hu.nye.fitnessSite.kaloriaBevitel;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kaloriabevitel")
    public class KaloriaBevitelRestController {

    private final KaloriaBevitelRepository kaloriaBevitelRepository;

    public KaloriaBevitelRestController(KaloriaBevitelRepository kaloriaBevitelRepository) {
        this.kaloriaBevitelRepository = kaloriaBevitelRepository;
    }

    @GetMapping("")
    List<KaloriaBevitel> findAll() {
        return kaloriaBevitelRepository.findAll();
    }

    @GetMapping("/{id}")
    KaloriaBevitel findById(@PathVariable Long id){
        Optional<KaloriaBevitel> bevitel = kaloriaBevitelRepository.findById(id);
        if (bevitel.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen kalória bevitel");
        }
        return bevitel.get();
    }

    public List<KaloriaBevitel> findByUId(@PathVariable Long felhasznaloId){
        List<KaloriaBevitel> bevitel = kaloriaBevitelRepository.findByFelhasznalo_Id(felhasznaloId);
        if (bevitel.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ennek a felhasználónak még nincs ilyenje");
        }
        return bevitel;
    }

    //post
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void create(@Valid @RequestBody KaloriaBevitel bevitel){
        kaloriaBevitelRepository.save(bevitel);
    }

    //put
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void put(@Valid @RequestBody KaloriaBevitel bevitel, @PathVariable Long id){
        Optional<KaloriaBevitel> optionalExisting = kaloriaBevitelRepository.findById(id);
        if (optionalExisting.isPresent()){
            KaloriaBevitel existing = optionalExisting.get();
            if (bevitel.getFelhasznalo() != null){
                existing.setFelhasznalo(bevitel.getFelhasznalo());
            }
            if (bevitel.getZsir() != null){
                existing.setZsir(bevitel.getZsir());
            }
            if (bevitel.getSzenhidrat() != null){
                existing.setSzenhidrat(bevitel.getSzenhidrat());
            }
            if (bevitel.getFeherje() != null){
                existing.setFeherje(bevitel.getFeherje());
            }
            if (bevitel.getViz() != null){
                existing.setViz(bevitel.getViz());
            }
            kaloriaBevitelRepository.save(existing);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem létezik ilyen bejegyzés");
        }
    }

    //delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@Valid @RequestBody @PathVariable Long id){
        if (!kaloriaBevitelRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A keresett bejegyzés nem létezik");
        }
        kaloriaBevitelRepository.deleteById(id);
    }
}
