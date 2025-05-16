package hu.nye.fitnessSite.felhasznalo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bejelentkezes")
public class FalhasznaloRestController {

    private final FelhasznaloRepository felhasznaloRepository;

    public FalhasznaloRestController(FelhasznaloRepository felhasznaloRepository) {
        this.felhasznaloRepository = felhasznaloRepository;
    }

    @GetMapping("")
    List<Felhasznalo> findAll(){
        return felhasznaloRepository.findAll();
    }

    @GetMapping("/{id}")
    Felhasznalo findById(@PathVariable Integer id){
        Optional<Felhasznalo> user = felhasznaloRepository.findById(id);
        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A felhasználó nem található!");
        }
        return user.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Felhasznalo felhasznalo){
        felhasznaloRepository.create(felhasznalo);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Felhasznalo felhasznalo, Integer id){
        felhasznaloRepository.update(felhasznalo, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@Valid @RequestBody Integer id){
        felhasznaloRepository.delete(id);
    }
}
