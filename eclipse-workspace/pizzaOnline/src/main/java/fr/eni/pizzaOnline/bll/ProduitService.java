package fr.eni.pizzaOnline.bll;

import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitService {

	void enregistrerProduit(Produit produit);

	List<Produit> consulterProduits();

	Produit getProduitById(int id);

	void modifierProduit(Produit produit);

	void supprimerProduit(Produit produit);

}
