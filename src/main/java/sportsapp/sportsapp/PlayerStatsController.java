package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;


@Slf4j
@Controller
@SessionAttributes("PlayerStats")
public class PlayerStatsController {

    private PlayerStatsRepository playerStatsRepository;

    public PlayerStatsController(PlayerStatsRepository playerStatsRepository) {this.playerStatsRepository = playerStatsRepository;}

    @Autowired
    PlayerStatsRepository service;



    @GetMapping("/addPlayerStats/{id}")
    public String showSignUpFormPlayer1(Player player) {
        return "addPlayerStats";
    }

    @PostMapping("/addPlayerStats/{id}")
    public String processPlayer1(@Valid PlayerStats playerStats, BindingResult result, SessionStatus sessionStatus,
                                 Player player, Model model) {
        if (result.hasErrors()) {
            return "player";
        }

        playerStats.setPlayer(player);
        service.save(playerStats);
        model.addAttribute("playerStats", service.findAll());
        return "redirect:/player";
    }


    @GetMapping("/editPlayerStats/{id}")
    public String showUpdateFixturesForm (@PathVariable("id") long id, Model model){
        PlayerStats playerStats = service.findAllById(id);
        model.addAttribute("playerStats", playerStats);
        return "editPlayerStats";
    }

    @PostMapping("/editPlayerStats/{id}")
    public String processPlayer1d(@Valid PlayerStats playerStats, BindingResult result, SessionStatus sessionStatus,
                                 Player player, Model model) {
        if (result.hasErrors()) {
            return "player";
        }

        playerStats.setPlayer(player);
        service.save(playerStats);
        model.addAttribute("playerStats", service.findAll());
        return "redirect:/player";
    }

    //PlayerStats

    @GetMapping("/PlayerStats/{id}")
    public String showUpdatePlayerForm3 (@PathVariable("id") long id, Model model){
        PlayerStats playerStats = service.findAllById(id);
        model.addAttribute("playerStats", playerStats);
        return "playerStats";
    }








}
