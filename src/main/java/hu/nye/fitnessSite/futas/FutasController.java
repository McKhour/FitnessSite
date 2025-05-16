package hu.nye.fitnessSite.futas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/futas")
public class FutasController {

    @GetMapping("")
    public String futas(){
        return "futas/futas";
    }

}
