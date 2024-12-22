package cz.uhk.kppro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller     // automaticky vytvori
public class IndexController {

    @GetMapping({"/", "/hello"})
    public String index(){
        return "index";
    }

    @GetMapping("/403")
    @ResponseBody
    public String forbidden(){
        return "ACCESS DENIED";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin(){
        return "ADMIN Section";
    }

}
