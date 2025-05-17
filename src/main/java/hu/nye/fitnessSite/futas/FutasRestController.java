package hu.nye.fitnessSite.futas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/futas")
public class FutasRestController {

    private final FutasRepository futasRepository;


    public FutasRestController(FutasRepository futasRepository){
        this.futasRepository = futasRepository;
    }

    @GetMapping("")
    List<Futas> findAll(){
        return futasRepository.findAll();
    }

    @GetMapping("/{id}")
    Futas findById(@PathVariable Long id){
        Optional<Futas> futas = futasRepository.findById(id);
        if (futas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Futás nem található");
        }
        return futas.get();
    }

    public List<Futas> findByUId(@PathVariable Long felhasznaloId){
        List<Futas> futas = futasRepository.findByFelhasznalo_Id(felhasznaloId);
        if (futas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nem található futás ilyen embertől");
        }
        return futas;
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Futas futas)
    {
        futasRepository.save(futas);
    }

    //put
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    void put(@Valid @RequestBody Futas futas, @PathVariable Long id) {
        Optional<Futas> optionalExisting = futasRepository.findById(id);
        if (optionalExisting.isPresent()) {
            Futas existing = optionalExisting.get();
            if (futas.getFelhasznalo() != null) {
                existing.setFelhasznalo(futas.getFelhasznalo());
            }
            if (futas.getFutasCim() != null){
                existing.setFutasCim(futas.getFutasCim());
            }
            if (futas.getFutasKezd() != null){
                existing.setFutasKezd(futas.getFutasKezd());
            }
            if (futas.getFutasVeg() != null){
                existing.setFutasVeg(futas.getFutasVeg());
            }
            if (futas.getKilometer() != null){
                existing.setKilometer(futas.getKilometer());
            }
            if (futas.getHelye() != null){
                existing.setHelye(futas.getHelye());
            }
            futasRepository.save(existing);
        } else {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen futás!");
        }
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable @RequestBody @Valid Long id)
    {
        if (!futasRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen futás");
        }
        futasRepository.deleteById(id);
    }

    //@GetMapping("/futas")
    //String futas(){
    //    return "A futás helye";
    //}
}
