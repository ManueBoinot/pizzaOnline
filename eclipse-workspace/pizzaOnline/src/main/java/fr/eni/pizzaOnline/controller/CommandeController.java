package fr.eni.pizzaOnline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.repository.EtatRepository;
import fr.eni.pizzaOnline.service.CommandeService;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@RequestMapping("/commander")
@SessionAttributes({ "produits", "commande" })
public class CommandeController {

	@Autowired
	ProduitService produitService;
	@Autowired
	CommandeService cs;
	@Autowired
	EtatRepository er;

	@ModelAttribute("commande")
	Commande setCommande() {
		return new Commande(er.findById((long) 1).get());
	}

	@ModelAttribute("produits")
	public List<Produit> initProduits() {
		return produitService.consulterProduits();
	}

	@GetMapping
	public String commander(Model model) {
		model.addAttribute("produits", produitService.consulterProduits());
		return "commander";
	}

	@PostMapping("/ajouter/{id:[0-9]+}")
	public String ajouterAuPanier(@PathVariable long id, @ModelAttribute("commande") Commande commande,
			@RequestParam int quantite) {
		commande = cs.ajouterProduitAuPanier(commande, quantite, produitService.getProduitById(id));
		return "redirect:/commander";
	}

}
