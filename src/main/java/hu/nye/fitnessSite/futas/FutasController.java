package hu.nye.fitnessSite.futas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import hu.nye.fitnessSite.felhasznalo.FelhasznaloRepository;

import java.util.List;

@Controller
@RequestMapping("/futas")
public class FutasController {

    @Autowired
    private final FutasServices futasServices;

    @Autowired
    private final FelhasznaloRepository felhasznaloRepository;

    public FutasController(FutasServices service, FelhasznaloRepository felhasznaloRepository){
        this.futasServices = service;
        this.felhasznaloRepository = felhasznaloRepository;
    }

    @GetMapping("/list")
    public String getAllFutas(Model model){
        List<Futas> futas = futasServices.getAllFutas();
        model.addAttribute("futok", futas);
        return "futas/futas";
    }

    @GetMapping("/uj")
    public String ujFutasForm(Model model){
        model.addAttribute("futo", new Futas());
        model.addAttribute("felhasznalok", felhasznaloRepository.findAll());
        return "futas/ujFutas";
    }

    @PostMapping("/uj")
    public String mentes(@ModelAttribute Futas futas){
        futasServices.save(futas);
        return "redirect:/futas/list";
    }

    @GetMapping("/szerkeszt/{id}")
    public String szerkesztFutasForm(@PathVariable Long id, Model model){
        Futas futas = futasServices.findById(id);
        model.addAttribute("futo", futas);
        model.addAttribute("felhasznalok", felhasznaloRepository.findAll());
        return "futas/szerkesztFutas";
    }

    @PostMapping("/szerkeszt")
    public String frissitFuto(@ModelAttribute Futas futas){
        futasServices.edit(futas);
        return "redirect:/futas/list";
    }

    @GetMapping("/torol/{id}")
    public String torlesMegerosito(@PathVariable Long id, Model model){
        Futas futas = futasServices.findById(id);
        model.addAttribute("futo", futas);
        model.addAttribute("felhasznalok", felhasznaloRepository.findAll());
        return "futas/torolFutas";
    }

    @PostMapping("/torol/{id}")
    public String deleteFutas(@PathVariable Long id){
        futasServices.deleteById(id);
        return "redirect:/futas/list";
    }
}
