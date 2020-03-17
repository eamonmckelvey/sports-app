package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@SessionAttributes("Player")
public class PlayerController {

    private PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {this.playerRepository = playerRepository;}

    @Autowired
    PlayerRepository service;


    @GetMapping("/player")
    public String displayPlayer(@PageableDefault(size = 10, sort = "playerName") Pageable pageable,
                               Model model) {
        Page<Player> page = playerRepository.findAll(pageable);
        List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());
        if (sortOrders.size() > 0) {
            Sort.Order order = sortOrders.get(0);
            model.addAttribute("sortProperty", order.getProperty());
            model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
        }
        model.addAttribute("page", page);
        return "player";
    }



    @GetMapping("/addPlayer")
    public String showSignUpFormPlayer(User user) {
        return "addPlayer";
    }

    @PostMapping("/addPlayer")
    public String processPlayer(@Valid Player player, BindingResult result, SessionStatus sessionStatus,
                                @AuthenticationPrincipal User user, Model model) {
        if (result.hasErrors()) {
            return "addPlayer";
        }

        player.setUser(user);
        service.save(player);
        model.addAttribute("player", service.findAll());
        return "redirect:/player";
    }



    @GetMapping("/editPlayer/{id}")
    public String showUpdatePlayerForm (@PathVariable("id") long id, Model model){
        Player player = service.findAllById(id);
        model.addAttribute("player", player);
        return "editPlayer";
    }

    @PostMapping("/updatePlayer/{id}")
    public String updatePlayer ( @PathVariable("id") long id, @Valid Player player,
                                 BindingResult result, Model model){
        if (result.hasErrors()) {
            player.setId(id);
            return "editPlayer";
        }


        service.save(player);
        model.addAttribute("player", service.findAll());
        return "redirect:/player";
    }


    @GetMapping("/deletePlayer/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        playerRepository.delete(player);
        model.addAttribute("player", playerRepository.findAll());
        return "redirect:/player";
    }


}
