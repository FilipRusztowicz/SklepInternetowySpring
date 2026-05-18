package com.example.sklepinternetowyprojekt.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    //@ResponseBody -> tego sie używa by nasłuchiwać tego, co funkcja pod nią zwróci
    public String home(){
        return "home"; //sam sobie szuka pliku o tej nazwie w template (bez roszerzenia sie pisze)
    }
}
