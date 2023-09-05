package fr.eni.pizzaOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.service.ProduitService;
import jakarta.websocket.server.PathParam;

@Controller
@SessionAttributes({ "produit", "produits" })
public class ProduitController {

	@Autowired
	ProduitService produitService;

	@ModelAttribute
	public List<Produit> initProduits() {
		return produitService.consulterProduits();
	}

	// **************************************************************
	// Afficher tous les produits ******************************
	@GetMapping("/carte")
	public String tousLesProduits(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "home";
	}

	@GetMapping("/carte/detail")
	public String detail(@PathParam("id") Long id, Model model) {
		produitService.getProduitById(id).ifPresent(o -> model.addAttribute("produit", o));
		return "detail";
	}

	// **************************************************************
	// Créer un nouveau produit ******************************
	@GetMapping("/enregistrerProduit")
	public String enregistrerProduitAcces(Model model) {
		model.addAttribute("produit", new Produit());
		return "enregistrerProduit";
	}

	@PostMapping("/enregistrerProduit")
	public String enregitrerProduit(Produit produit) {
		produitService.enregistrerProduit(produit);
		return "redirect:/carte";
	}

	// **************************************************************
	// Modifier un produit ******************************
	@GetMapping("/modifierProduit/{id}")
	public String modifierProduitAcces(@PathVariable("id") Long id, Model model) {
		produitService.getProduitById(id).ifPresent(o -> model.addAttribute("produit", o));
		return "modifierProduit";
	}

	@PostMapping("/modifierProduit/{id}")
	public String modifierProduit(@PathVariable("id") Long id, Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			produit.setId(id);
			return "modifierProduit";
		}
		produitService.modifierProduit(produit, id);
		return "redirect:/carte";
	}

	// **************************************************************
	// Supprimer un produit ******************************
	@GetMapping("/supprimerProduit/{id}")
	public String supprimerProduit(@PathVariable("id") Long id, Model model) {
		produitService.supprimerProduit(id);
		return "redirect:/carte";
	}

}
