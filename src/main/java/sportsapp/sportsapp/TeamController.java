package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

    /*

     */

    @GetMapping("/team")
    public String displayTeam(Model model) {
        List<Team> all = service.findAll();

        model.addAttribute("team", all);

        return "/team";
    }

    @GetMapping("/addTeam")
    public String showSignUpForm(SessionStatus sessionStatus,
                                 @AuthenticationPrincipal User user, Model model) {
        //if the user has already the team we should not let them add another one
        //this is due to having one to one rleationship
        long userHasTeamCount = service.countAllByUser(user);
        int returnMsg;
        if (userHasTeamCount > 0) {


           //JFrame parent = new JFrame();

            JOptionPane.showMessageDialog(null,
                    "YOU ALREADY HAVE A TEAM, ONE PER USER.");
           return "redirect:team";

        }

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
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Team team = service.findAllById(id);
        model.addAttribute("team", team);
        return "editTeam";
    }

    @PostMapping("/update/{id}")
    public String updateTeam(@PathVariable("id") long id, @Valid Team team,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            team.setId(id);
            return "editTeam";
        }


        service.save(team);
        model.addAttribute("team", service.findAll());
        return "redirect:/team";
    }

}
