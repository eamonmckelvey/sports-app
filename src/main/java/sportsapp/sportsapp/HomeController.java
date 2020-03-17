package sportsapp.sportsapp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")

    public String displayHome(Model model) {
        return "/home";
    }






}
