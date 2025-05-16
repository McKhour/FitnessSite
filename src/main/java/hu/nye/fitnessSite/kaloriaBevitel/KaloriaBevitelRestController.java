package hu.nye.fitnessSite.kaloriaBevitel;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kaloriaBevitel")
    public class KaloriaBevitelRestController {

    private final KaloriaBevitelRepository kaloriaBevitelRepository;

    public KaloriaBevitelRestController(KaloriaBevitelRepository kaloriaBevitelRepository) {
        this.kaloriaBevitelRepository = kaloriaBevitelRepository;
    }

    @GetMapping("")
    List<KaloriaBevitel> findAll(){
        return kaloriaBevitelRepository.findAll();
    }

    @GetMapping("/{id}")
    KaloriaBevitel findById(@PathVariable Integer id){
        Optional<KaloriaBevitel> kaloriaBevitel = kaloriaBevitelRepository.findById(id);
        if (kaloriaBevitel.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kalóriabevitel nem található");
        }
        return kaloriaBevitel.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody KaloriaBevitel kaloriaBevitel)
    {
        kaloriaBevitelRepository.create(kaloriaBevitel);
    }
    //updte
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody KaloriaBevitel kaloriaBevitel, @PathVariable Integer id){
        kaloriaBevitelRepository.update(kaloriaBevitel, id);
    }
    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id)
    {
        kaloriaBevitelRepository.delete(id);
    }

    //@GetMapping("/kaloriaBevitel")
    //String kaloria(){
    //    return "Ez itt a kalória oldala";
    //}
}
