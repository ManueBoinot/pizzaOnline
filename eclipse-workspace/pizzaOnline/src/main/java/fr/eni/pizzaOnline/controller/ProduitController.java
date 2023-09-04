package fr.eni.pizzaOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.bll.ProduitService;

@Controller
@RequestMapping("/carte")
@SessionAttributes({"produits"})
public class ProduitController {
	
	private ProduitService produitService;
	
	public ProduitController(ProduitService produitService) {
		this.produitService = produitService;
	}

	@GetMapping
	String index() {
		return "carte";
	}

	@PostMapping("/enregistrerProduit")
	String enregitrerProduit() {
		return "carte";
	}

	@PostMapping("/modifierProduit")
	String modifierProduit() {
		return "carte";
	}

	@PostMapping("/supprimerProduit")
	String supprimerProduit() {
		return "carte";
	}
}
