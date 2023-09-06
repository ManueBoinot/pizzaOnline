package fr.eni.pizzaOnline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@RequestMapping("/")
@SessionAttributes({ "produit", "produits" })
public class ProduitController {
	
	Logger logger = LoggerFactory.getLogger(ProduitController.class);

	@Autowired
	ProduitService produitService;

	@ModelAttribute
	public List<Produit> initProduits() {
		return produitService.consulterProduits();
	}

	@GetMapping
	public String home(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "home";
	}

	// **************************************************************
	// Afficher un produit ******************************
	@GetMapping("/carte/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		produitService.getProduitById(id).ifPresent(o -> model.addAttribute("produit", o));
		return "detail";
	}

	// **************************************************************
	// Créer un nouveau produit ******************************
	@GetMapping("/private/enregistrerProduit")
	public String enregistrerProduitAcces(Model model) {
		model.addAttribute("produit", new Produit());
		return "enregistrerProduit";
	}

	@PostMapping("/private/enregistrerProduit")
	public String enregitrerProduit(Produit produit) {
		produitService.enregistrerProduit(produit);
		return "redirect:/home";
	}

	// **************************************************************
	// Modifier un produit ******************************
	@GetMapping("/private/modifierProduit/{id}")
	public String modifierProduitAcces(@PathVariable("id") Long id, Model model) {
		produitService.getProduitById(id).ifPresent(o -> model.addAttribute("produit", o));
		return "modifierProduit";
	}

	@PostMapping("/private/modifierProduit/{id}")
	public String modifierProduit(@PathVariable("id") Long id, Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			produit.setId(id);
			return "modifierProduit";
		}
		produitService.modifierProduit(produit, id);
		return "redirect:/home";
	}

	// **************************************************************
	// Supprimer un produit ******************************
	@GetMapping("/private/supprimerProduit/{id}")
	public String supprimerProduit(@PathVariable("id") Long id, Model model) {
		produitService.supprimerProduit(id);
		return "redirect:/";
	}

}
