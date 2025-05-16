package hu.nye.fitnessSite.sulyEmeles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sulyEmeles")
public class SulyController {
    @GetMapping("")
    public String futas(){
        return "sulyEmeles/sulyEmeles";
    }
}
