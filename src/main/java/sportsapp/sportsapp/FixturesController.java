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
@SessionAttributes("Fixtures")
//@SessionAttributes("team")
public class FixturesController {

    private FixturesRepository fixturesRepository;

    public FixturesController(FixturesRepository fixturesRepository) {
        this.fixturesRepository = fixturesRepository;
    }

    @Autowired
    FixturesRepository service;
    @GetMapping("/fixtures")
    public String displayFixtures(Model model) {

        model.addAttribute("fixtures", service.findAll());

        return "/fixtures";
    }

    @GetMapping("/addFixtures")
    public String showSignUpFormFixtures(User user) {
        return "addFixtures";
    }

    @PostMapping("/addFixtures")
    public String processFixtures(@Valid Fixtures fixtures, BindingResult result, SessionStatus sessionStatus,
                                 @AuthenticationPrincipal User user, Model model) {
        if (result.hasErrors()) {
            return "addFixtures";
        }

        //
        //
        fixtures.setUser(user);
        service.save(fixtures);
        model.addAttribute("fixtures", service.findAll());
        return "fixtures";
    }


/*
    @GetMapping("/team")
    public String displayTeam(Model model) {

        model.addAttribute("team", service.findAll());

        return "/team";
    }

    @PostMapping("/team")
    public String processOrder(@Valid Team team, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "team";
        }

        team.setUser(user);

        service.save(team);
        sessionStatus.setComplete();

        return "redirect:/team";
    }*/

    @GetMapping("/editFixtures/{id}")
    public String showUpdateFixturesForm (@PathVariable("id") long id, Model model){
        Fixtures fixtures = service.findAllById(id);
        model.addAttribute("fixtures", fixtures);
        return "editFixtures";
    }

    @PostMapping("/updateFixtures/{id}")
    public String updateFixtures ( @PathVariable("id") long id, @Valid Fixtures fixtures,
                                 BindingResult result, Model model){
        if (result.hasErrors()) {
            fixtures.setId(id);
            return "editFixtures";
        }


        service.save(fixtures);
        model.addAttribute("fixtures", service.findAll());
        return "redirect:/fixtures";
    }


    @GetMapping("/deleteFixtures/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Fixtures fixtures  = fixturesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        fixturesRepository.delete(fixtures);
        model.addAttribute("fixtures", fixturesRepository.findAll());
        return "redirect:/fixtures";
    }

}

