package hu.nye.fitnessSite.felhasznalo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/felhasznalo")
public class FelhasznaloRestController {

    private final FelhasznaloRepository felhasznaloRepository;

    public FelhasznaloRestController(FelhasznaloRepository felhasznaloRepository) {
        this.felhasznaloRepository = felhasznaloRepository;
    }

    @GetMapping("")
    List<Felhasznalo> findAll(){
        return felhasznaloRepository.findAll();
    }

    @GetMapping("/{id}")
    Felhasznalo findById(@PathVariable Long id) {
        Optional<Felhasznalo> user = felhasznaloRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A felhasználó nem található!");
        }
        return user.get();
    }
    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Felhasznalo felhasznalo){
        felhasznaloRepository.save(felhasznalo);
    }
    //put
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    void put(@Valid @RequestBody Felhasznalo felhasznalo, @PathVariable Long id){

        Optional<Felhasznalo> optionalExisting = felhasznaloRepository.findById(id);
        if (optionalExisting.isPresent()) {
            Felhasznalo existing = optionalExisting.get();
            if (felhasznalo.getEletkor() != null) {
                existing.setEletkor(felhasznalo.getEletkor());
            }
            if (felhasznalo.getEmail() != null) {
                existing.setEmail(felhasznalo.getEmail());
            }
            if (felhasznalo.getKeresztNev() != null) {
                existing.setKeresztNev(felhasznalo.getKeresztNev());
            }
            if (felhasznalo.getTestSuly() != null) {
                existing.setTestSuly(felhasznalo.getTestSuly());
            }
            if (felhasznalo.getVezetekNev() != null) {
                existing.setVezetekNev(felhasznalo.getVezetekNev());
            }
            felhasznaloRepository.save(existing);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A felhsználó nem található!");
        }

    }
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@Valid @RequestBody @PathVariable Long id) {
        if (!felhasznaloRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A felhaszználó nem találhtó!");
        }
        felhasznaloRepository.deleteById(id);
    }
}
