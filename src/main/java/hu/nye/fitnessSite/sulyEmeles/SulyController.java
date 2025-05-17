package hu.nye.fitnessSite.sulyEmeles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sulyEmeles")
public class SulyController {

    private SulyEmelesRestController sulyRest;

    @Autowired
    public SulyController(SulyEmelesRestController sulyRest){
        this.sulyRest = sulyRest;
    }

    @GetMapping("/list")
    public String sulyList(Model model){
        List<SulyEmeles> suly = sulyRest.findAll();
        model.addAttribute("suly", suly);
        return "sulyEmeles/sulyEmeles";
    }
}
