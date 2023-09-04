package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.pizzaOnline.bll.ProduitService;

@Controller
public class MainController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/")
	public String tousLesProduits(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "home";
	}
}
