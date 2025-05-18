package hu.nye.fitnessSite.kaloriaBevitel;

import hu.nye.fitnessSite.felhasznalo.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/kaloriaBevitel")
public class KaloriaController {

    @Autowired
    private final KaloriaServices kaloriaServices;

    @Autowired
    private final FelhasznaloRepository felhasznaloRepo;

    public KaloriaController(KaloriaServices kaloriaServices, FelhasznaloRepository felhasznaloRepo) {
        this.kaloriaServices = kaloriaServices;
        this.felhasznaloRepo = felhasznaloRepo;
    }

    @GetMapping("/list")
    public String getAllKaloria(Model model){
        List<KaloriaBevitel> kaloria = kaloriaServices.getAllKaloria();
        model.addAttribute("kaloria", kaloria);
        return "kaloriaBevitel/kaloriaBevitel";
    }

    @GetMapping("/uj")
    public String ujKaloriaForm(Model model){
        model.addAttribute("kaloriak", new KaloriaBevitel());
        model.addAttribute("felhasznalok", felhasznaloRepo.findAll());
        return "kaloriaBevitel/ujKaloriaBevitel";
    }

    @PostMapping("/uj")
    public String mentes(@ModelAttribute KaloriaBevitel kaloriaB){
        kaloriaServices.save(kaloriaB);
        return "redirect:/kaloriaBevitel/list";
    }

    @GetMapping("/szerkeszt/{id}")
    public String szerkesztKaloriaForm(@PathVariable Long id, Model model){
        KaloriaBevitel kaloria = kaloriaServices.findById(id);
        model.addAttribute("kaloria", kaloria);
        model.addAttribute("felhasznalok", felhasznaloRepo.findAll());
        return "kaloriaBevitel/szerkesztKaloriaBevitel";
    }

    @PostMapping("/szerkeszt")
    public String frissitKaloria(@ModelAttribute KaloriaBevitel kaloria){
        kaloriaServices.edit(kaloria);
        return "redirect:/kaloriaBevitel/list";
    }

    @GetMapping("/torol/{id}")
    public String torlesMegerosito(@PathVariable Long id, Model model){
        KaloriaBevitel kaloria = kaloriaServices.findById(id);
        model.addAttribute("kaloria", kaloria);
        model.addAttribute("felhasznalok", felhasznaloRepo.findAll());
        return "kaloriaBevitel/torolKaloriaBevitel";
    }

    @PostMapping("/torol/{id}")
    public String deleteKaloria(@PathVariable long id){
        kaloriaServices.deleteById(id);
        return "redirect:/kaloriaBevitel/list";
    }
}
