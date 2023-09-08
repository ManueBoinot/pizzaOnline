package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Produit;

public interface ProduitService {

	Produit enregistrerProduit(Produit produit);

	List<Produit> consulterProduits();

	Optional<Produit> getProduitById(Long id);

	Produit modifierProduit(Produit produit, Long id);

	void supprimerProduit(Long id);

}
