package fr.eni.pizzaOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.repository.EtatRepository;
import fr.eni.pizzaOnline.service.CommandeService;
import fr.eni.pizzaOnline.service.ProduitService;

@Controller
@RequestMapping("/panier")
@SessionAttributes({"commande"})
public class PanierController {

	@Autowired
	ProduitService ps;
	@Autowired
	CommandeService cs;
	@Autowired
	EtatRepository er;
	
	@GetMapping
	public String afficherPanier(Model model, @ModelAttribute("commande") Commande commande) {
		model.addAttribute("detailsCommande",commande.getDetailsCommande());
		model.addAttribute("totalPrix",cs.getTotalPrixCommande(commande));
		return "panier";
	}
	
	@GetMapping("/ajouterQuantite/{id:[0-9]+}")
	public String ajouterQuantite(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		System.out.println(commande.getDetailsCommande());
		commande = cs.ajouterQuantiteProduitParID(commande, ps.getProduitById(id));
		return "redirect:/panier";
	}
	
	@GetMapping("/soustraireQuantite/{id:[0-9]+}")
	public String soustraireQuantite(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		commande = cs.soustraireQuantiteProduitParID(commande, ps.getProduitById(id));
		return "redirect:/panier";
	}
	
	@GetMapping("/supprimer/{id:[0-9]+}")
	public String supprimerProduitDuPanier(@PathVariable long id, @ModelAttribute("commande") Commande commande) {
		commande = cs.supprimerProduitParID(commande, ps.getProduitById(id));
		return "redirect:/panier";
	}
	
	@GetMapping("/commander")
	public String commanderPanier(@ModelAttribute("commande") Commande commande) {
		commande.setEtat(er.findById((long) 2).get());
		cs.ajouterUneCommande(commande);
		commande.resetCommande();
		commande.setEtat(er.findById((long) 1).get());
		return "redirect:/commander";
	}
	
}
