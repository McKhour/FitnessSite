package hu.nye.fitnessSite.felhasznalo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/felhasznalo")
public class FelhasznaloController {

    @GetMapping("")
    public String felhasznalo(){
        return "felhasznalo/felhasznalo";
    }
}
