package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnline.service.CommandeService;

@Controller
@RequestMapping("/preparation")
public class PreparationController {

	@Autowired
	CommandeService cs;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("commandes", cs.consulterCommandesAPreparer());
		return "preparationCommande";
	}
	
	@PostMapping("/preparer/{id:[0-9]+}")
	public String commandePreparer(@PathVariable long id) {
		cs.passerCommandeEnPreparerParID(id);
		return "redirect:/preparation";
	}
	
}
