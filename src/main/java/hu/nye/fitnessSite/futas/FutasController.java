package hu.nye.fitnessSite.futas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FutasController {

    @GetMapping("/futas")
    String futas(){
        return "Ez itt a futás oldala lesz";
    }
}
