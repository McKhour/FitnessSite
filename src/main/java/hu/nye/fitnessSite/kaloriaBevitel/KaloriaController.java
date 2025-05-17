package hu.nye.fitnessSite.kaloriaBevitel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kaloriaBevitel")
public class KaloriaController {

    private KaloriaBevitelRestController kaloriaRest;

    @Autowired
    public KaloriaController(KaloriaBevitelRestController kaloriaRest){
        this.kaloriaRest = kaloriaRest;
    }

    @GetMapping("/list")
    public String kaloriaList(Model model){
        List<KaloriaBevitel> kaloria = kaloriaRest.findAll();
        model.addAttribute("kaloria", kaloria);
        return "kaloriaBevitel/kaloriaBevitel";
    }
}
