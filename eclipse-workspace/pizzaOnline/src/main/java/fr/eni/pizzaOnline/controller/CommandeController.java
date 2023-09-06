package fr.eni.pizzaOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@RequestMapping("/commander")
@SessionAttributes({"produits"})
public class CommandeController {

	@Autowired
	ProduitService produitService;

	@ModelAttribute
	public List<Produit> initProduits() {
		return produitService.consulterProduits();
	}
	
	@GetMapping
	public String commander(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "commander";
	}

}
