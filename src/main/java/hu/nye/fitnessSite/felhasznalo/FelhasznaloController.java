package hu.nye.fitnessSite.felhasznalo;

import hu.nye.fitnessSite.felhasznalo.FelhasznaloRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/felhasznalo")
public class FelhasznaloController {

    private final FelhasznaloRestController felhasznaloRest;

    @Autowired
    public FelhasznaloController(FelhasznaloRestController felhasznaloRest) {
        this.felhasznaloRest = felhasznaloRest;
    }

    @GetMapping("/list")
    public String felhasznaloList(Model model){
        List<Felhasznalo> felhasz = felhasznaloRest.findAll();
        model.addAttribute("felhasznalok", felhasz); // jobban hangzik többes számban
        return "felhasznalo/felhasznalo"; // ez a felhasznalo.html fájl lesz
    }
}
