package fr.eni.pizzaOnline.bll;

import java.util.List;

import fr.eni.pizzaOnline.bo.Produit;

public interface ProduitService {
	
	void creerProduit(Produit produit);
	List<Produit> consulterProduits();
	

}
