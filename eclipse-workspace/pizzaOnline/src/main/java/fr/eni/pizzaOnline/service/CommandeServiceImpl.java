package fr.eni.pizzaOnline.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.entity.DetailCommande;
import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository;

	@Override
	public Commande ajouterProduitAuPanier(Commande commande, int quantite, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(quantite, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			quantite+=commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite();
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		} else {
			commande.getDetailsCommande().add(detailCommandeToAdd);
		}
		return commande;
	}
	
	@Override
	public Commande ajouterQuantiteProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			int quantite = commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite()+1;
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		}
		return commande;
	}

	@Override
	public Commande soustraireQuantiteProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToAdd = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToAdd)) {
			int quantite = commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).getQuantite()-1;
			commande.getDetailsCommande().get(commande.getDetailsCommande().indexOf(detailCommandeToAdd)).setQuantite(quantite);
		}
		return commande;
	}

	@Override
	public Commande supprimerProduitParID(Commande commande, Produit produit) {
		DetailCommande detailCommandeToSuppr = new DetailCommande(1, commande, produit);
		if(commande.getDetailsCommande().contains(detailCommandeToSuppr)) {
			commande.getDetailsCommande().remove(detailCommandeToSuppr);
		}
		return commande;
	}

	@Override
	public float getTotalPrixCommande(Commande commande) {
		float totalPrix = 0;
		for (DetailCommande detailCommande : commande.getDetailsCommande()) {
			totalPrix += detailCommande.getProduit().getPrix()*detailCommande.getQuantite();
		}
		return totalPrix;
	}

	@Override
	public void ajouterUneCommande(Commande commande) {
		System.err.println("début ajout commande");
		commande.setDateHeureLivraison(LocalDateTime.now().plusHours(2));
		commande.setDateHeurePreparation(LocalDateTime.now().plusHours(1));
		System.err.println("milieu ajout commande");
		System.err.println(commande.getId());
		commandeRepository.save(commande);
		System.err.println(commande);
	}	
	
	
	
	

	@Override
	public List<Commande> consulterCommandes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Commande> getCommandeById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Commande modifierCommande(Commande commande, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
