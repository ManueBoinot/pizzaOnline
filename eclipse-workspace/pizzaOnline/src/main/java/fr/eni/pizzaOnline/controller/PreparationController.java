package fr.eni.pizzaOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.service.CommandeService;

@Controller
@RequestMapping("/preparation")
public class PreparationController {

	@Autowired
	CommandeService cs;
	
	@GetMapping
	public String home(Model model) {
		System.out.println(cs.consulterCommandesAPreparer());
		List<Commande> test1 = cs.consulterCommandesAPreparer();
		Commande test2 = test1.get(0);
		String test3 = test2.getDetailsCommande().get(0).getProduit().getNom();
		System.out.println(test3);
		model.addAttribute("commandes", cs.consulterCommandesAPreparer());
		return "preparationCommande";
	}
	
}
