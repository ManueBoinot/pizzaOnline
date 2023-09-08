package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.entity.Produit;

public interface CommandeService {
	
	Commande ajouterProduitAuPanier(Commande commande, int quantite, Produit produit);
	Commande ajouterQuantiteProduitParID(Commande commande, Produit produit);
	Commande soustraireQuantiteProduitParID(Commande commande, Produit produit);
	Commande supprimerProduitParID(Commande commande, Produit produit);
	float getTotalPrixCommande(Commande commande);
	
	
	
	void ajouterUneCommande(Commande commande);

	List<Commande> consulterCommandes();
	
	List<Commande> consulterCommandesAPreparer();

	Optional<Commande> getCommandeById(Long id);

	Commande modifierCommande(Commande commande, Long id);
	
	void passerCommandeEnPreparerParID(long id);
	
	

}
