package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes("Team")
//@SessionAttributes("team")
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Autowired
    TeamRepository service;

    /*

     */

    @GetMapping("/team")
    public String displayTeam(Model model) {

        model.addAttribute("team", service.findAll());

        return "/team";
    }

    @GetMapping("/addTeam")
    public String showSignUpForm(User user) {
        return "addTeam";
    }

    @PostMapping("/addTeam")
    public String processOrder(@Valid Team team, BindingResult result, SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user, Model model) {
        if (result.hasErrors()) {
            return "addTeam";
        }

        team.setUser(user);
        service.save(team);
        model.addAttribute("team", service.findAll());
        return "team";
    }

        @GetMapping("/edit/{id}")
        public String showUpdateForm ( @PathVariable("id") long id, Model model){
            Team team = service.findAllById(id);
            model.addAttribute("team", team);
            return "editTeam";
        }

        @PostMapping("/update/{id}")
        public String updateTeam ( @PathVariable("id") long id, @Valid Team team,
        BindingResult result, Model model){
            if (result.hasErrors()) {
                team.setId(id);
                return "editTeam";
            }


            service.save(team);
            model.addAttribute("team", service.findAll());
            return "redirect:/team";
        }

    }
