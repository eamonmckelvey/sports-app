package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/edit")
@SessionAttributes("Team")
//@SessionAttributes("team")
public class EditTeamController {

    private TeamRepository teamRepository;

    public EditTeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Autowired
    TeamRepository service;

    /*

     */


    @PostMapping
    public String processOrder(@Valid Team team, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "www.google.com";
        }

        team.setUser(user);

        service.save(team);
        sessionStatus.setComplete();

        return "redirect:/team";
    }


    @GetMapping
    public String displayTeam(Model model) {

        model.addAttribute("team", service.findAll());

        return "/team";
    }











}