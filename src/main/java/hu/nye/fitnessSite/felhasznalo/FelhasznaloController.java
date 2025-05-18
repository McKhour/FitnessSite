package hu.nye.fitnessSite.felhasznalo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/felhasznalo")
public class FelhasznaloController {

    @Autowired
    private final FelhasznaloServices felhasznaloServices;

    public FelhasznaloController(FelhasznaloServices service) {
        this.felhasznaloServices = service;
    }

    @GetMapping("/list")
    public String getAllFelhaszn(Model model){
        List<Felhasznalo> felhasz = felhasznaloServices.getAllFelhaszn();
        model.addAttribute("felhasznalok", felhasz);
        return "felhasznalo/felhasznalo";
    }

    @GetMapping("/uj")
    public String ujFelhasznaloForm(Model model) {
        model.addAttribute("felhasznalo", new Felhasznalo());
        return "felhasznalo/ujFelhasznalo";
    }

    @PostMapping("/uj")
    public String mentes(@ModelAttribute Felhasznalo felhasznalo) {
        felhasznaloServices.save(felhasznalo); // Meghívja a REST controllert
        return "redirect:/felhasznalo/list";
    }

    @GetMapping("/szerkeszt/{id}")
    public String szerkesztFelhasznForm(@PathVariable Long id, Model model){
        Felhasznalo felhasznalo = felhasznaloServices.findById(id);
        model.addAttribute("felhasznalo", felhasznalo);
        return "felhasznalo/szerkesztFelhasznalo";
    }

    @PostMapping("/szerkeszt")
    public String frissitFelhaszn(@ModelAttribute Felhasznalo felhasznalo){
        felhasznaloServices.edit(felhasznalo);
        return "redirect:/felhasznalo/list";
    }

    @GetMapping("/torol/{id}")
    public String torlesMegerosites(@PathVariable Long id, Model model) {
        Felhasznalo felhasznalo = felhasznaloServices.findById(id);
        model.addAttribute("felhasznalo", felhasznalo);
        return "felhasznalo/torolFelhasznalo";
    }


    @PostMapping("/torol/{id}")
    public String deleteFelhaszn(@PathVariable Long id){
        felhasznaloServices.deleteById(id);
        return "redirect:/felhasznalo/list";
    }
}
