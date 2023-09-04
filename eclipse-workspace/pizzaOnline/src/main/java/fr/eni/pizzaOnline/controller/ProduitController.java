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

import fr.eni.pizzaOnline.bll.ProduitService;
import fr.eni.pizzaOnline.bo.Produit;
import jakarta.websocket.server.PathParam;

@Controller
@SessionAttributes({ "produit", "produits" })
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	@ModelAttribute
	public List<Produit> initProduits() {
		return produitService.consulterProduits();
	}

	public ProduitController(ProduitService produitService) {
		this.produitService = produitService;
	}

	// **************************************************************
	// Afficher tous les produits ******************************
	@GetMapping("/carte")
	public String tousLesProduits(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "home";
	}

	@GetMapping("/carte/detail")
	public String detail(@PathParam("id") int id, Model model) {
		model.addAttribute("produit", produitService.getProduitById(id));
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
	public String modifierProduitAcces(@PathVariable("id") int id, Model model) {
		Produit produit = produitService.getProduitById(id);
		model.addAttribute("produit", produit);
		return "modifierProduit";
	}

	@PostMapping("/modifierProduit/{id}")
	public String modifierProduit(@PathVariable("id") int id, Produit produit, BindingResult result, Model model) {
		if (result.hasErrors()) {
			produit.setId(id);
			return "modifierProduit";
		}
		produitService.modifierProduit(produit);
		return "redirect:/carte";
	}

	// **************************************************************
	// Supprimer un produit ******************************
	@GetMapping("/supprimerProduit/{id}")
	public String supprimerProduit(@PathVariable("id") int id, Model model) {
		Produit produit = produitService.getProduitById(id);
		produitService.supprimerProduit(produit);
		return "redirect:/carte";
	}

}
