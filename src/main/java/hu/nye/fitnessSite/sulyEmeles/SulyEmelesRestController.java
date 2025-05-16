package hu.nye.fitnessSite.sulyEmeles;

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
    SulyEmeles findById(@PathVariable Integer id){
        Optional<SulyEmeles> suly = sulyEmelesRepository.findById(id);
        if (suly.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Súly emelés nem található");
        }
        return suly.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody SulyEmeles suly)
    {
        sulyEmelesRepository.create(suly);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody SulyEmeles suly, @PathVariable Integer id){
        sulyEmelesRepository.update(suly, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id)
    {
        sulyEmelesRepository.delete(id);
    }

    //@GetMapping("/sulyEmeles")
    //String sulyEmeles(){
    //    return "Ez itt a súly emelés helye";
    //}
}
