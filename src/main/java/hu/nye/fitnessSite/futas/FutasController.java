package hu.nye.fitnessSite.futas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/futas")
public class FutasController {

    private final FutasRepository futasRepository;

    public FutasController(FutasRepository futasRepository){
        this.futasRepository = futasRepository;
    }

    @GetMapping("")
    List<Futas> findAll(){
        return futasRepository.findAll();
    }

    @GetMapping("/{id}")
    Futas findById(@PathVariable Integer id){
        Optional<Futas> futas = futasRepository.findById(id);
        if (futas.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Futás nem található");
        }
        return futas.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Futas futas)
    {
        futasRepository.create(futas);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Futas futas, @PathVariable Integer id)
    {
        futasRepository.update(futas, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id)
    {
        futasRepository.delete(id);

    }

    //@GetMapping("/futas")
    //String futas(){
    //    return "A futás helye";
    //}
}
