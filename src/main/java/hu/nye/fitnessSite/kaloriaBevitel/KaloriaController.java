package hu.nye.fitnessSite.kaloriaBevitel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kaloriaBevitel")
public class KaloriaController {

    @GetMapping("")
    public String kaloriaBevitel(){
        return "kaloriaBevitel/kaloriaBevitel";
    }
}
