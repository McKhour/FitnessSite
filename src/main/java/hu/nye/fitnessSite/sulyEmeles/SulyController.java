package hu.nye.fitnessSite.sulyEmeles;

import hu.nye.fitnessSite.felhasznalo.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sulyEmeles")
public class SulyController {

    @Autowired
    private final SulyServices sulyServices;

    @Autowired
    private final FelhasznaloRepository felhasznaloRepository;

    public SulyController(SulyServices services, FelhasznaloRepository felhasznaloRepository) {
        this.sulyServices = services;
        this.felhasznaloRepository = felhasznaloRepository;
    }

    @GetMapping("/list")
    public String getAllSuly(Model model){
        List<SulyEmeles> suly = sulyServices.getAllSuly();
        model.addAttribute("sulyok", suly);
        return "sulyEmeles/sulyEmeles";
    }

    @GetMapping("/uj")
    public String ujSulyForm(Model model){
        model.addAttribute("suly", new SulyEmeles());
        model.addAttribute("felhasznalok", felhasznaloRepository.findAll());
        return "sulyEmeles/ujSulyEmeles";
    }

    @PostMapping("/uj")
    public String mentes(@ModelAttribute SulyEmeles sulyEmeles){
        sulyServices.save(sulyEmeles);
        return "redirect:/sulyEmeles/list";
    }

    @GetMapping("/szerkeszt/{id}")
    public String szerkesztSulyForm(@PathVariable Long id, Model model){
        SulyEmeles suly = sulyServices.findById(id);
        model.addAttribute("suly", suly);
        model.addAttribute("felhasznalo", felhasznaloRepository.findAll());
        return "sulyEmeles/szerkesztSulyEmeles";
    }

    @PostMapping("/szerkeszt")
    public String frissitSuly(@ModelAttribute SulyEmeles suly){
        sulyServices.edit(suly);
        return "redirect:/sulyEmeles/list";
    }

    @GetMapping("/torol/{id}")
    public String torlesMegerosito(@PathVariable Long id, Model model){
        SulyEmeles suly = sulyServices.findById(id);
        model.addAttribute("suly", suly);
        model.addAttribute("felhasznalo", felhasznaloRepository.findAll());
        return "sulyEmeles/torolSulyEmeles";
    }

    @PostMapping("/torol/{id}")
    public String deleteSuly(@PathVariable Long id){
        sulyServices.deleteById(id);
        return "redirect:/sulyEmeles/list";
    }
}
