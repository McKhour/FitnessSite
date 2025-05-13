package hu.nye.fitnessSite.sulyEmeles;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SulyEmelesController {

    @GetMapping("/sulyEmeles")
    String sulyEmeles(){
        return "Ez itt a súly emelés helye";
    }
}
