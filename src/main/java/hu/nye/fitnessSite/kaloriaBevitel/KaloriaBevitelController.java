package hu.nye.fitnessSite.kaloriaBevitel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KaloriaBevitelController {

    @GetMapping("/kaloriaBevitel")
    String kaloria(){
        return "Ez itt a kalória oldala";
    }
}
