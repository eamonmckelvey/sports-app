package sportsapp.sportsapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {

    @RequestMapping("/aboutjj")
    public String displayAbout(Model model) {
        return "/aboutnn";
    }
}
