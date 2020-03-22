package sportsapp.sportsapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@SessionAttributes("PlayerStats")
public class PlayerStatsController {

	private PlayerStatsRepository playerStatsRepository;

	@Autowired
	private PlayerRepository playerRepository;

	public PlayerStatsController(PlayerStatsRepository playerStatsRepository) {this.playerStatsRepository = playerStatsRepository;}

	@Autowired
	PlayerStatsRepository service;



	@GetMapping("/addPlayerStats/{id}")
	public String showSignUpFormPlayer1(Player player) {
		return "addPlayerStats";
	}

	@PostMapping("/addPlayerStats/{id}")
	public String processPlayer1(@Valid PlayerStats playerStats, BindingResult result, SessionStatus sessionStatus,
								 Player player, Fixtures fixtures, Model model) {
		if (result.hasErrors()) {
			return "player";
		}

		playerStats.setPlayer(player);
		playerStats.setId(null);
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

		//player id is being passed so we'll get the player first
		Optional<Player> playerFound = playerRepository.findById(id);


		//get the stats for this partciular player
		List<PlayerStats> playerStats = service.findAllByPlayer(playerFound.get());
		model.addAttribute("playerStats", playerStats);
		return "playerStats";
	}








}
