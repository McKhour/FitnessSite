package hu.nye.fitnessSite.futas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/futas")
public class FutasController {

    private FutasRestController futasRest;

    @Autowired
    public FutasController(FutasRestController futasRest){
        this.futasRest = futasRest;
    }

    @GetMapping("/list")
    public String futasList(Model model){
        List<Futas> futas = futasRest.findAll();
        model.addAttribute("futok", futas);
        return "futas/futas";
    }

}
