package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.TypeProduit;

public interface TypeProduitService {
	
	TypeProduit creerTypeProduit(TypeProduit typeProduit);
	
	List<TypeProduit> consulterTypeProduits();
	
	Optional<TypeProduit> getTypeProduitById(Long id);
	
	TypeProduit modifierTypeProduit(TypeProduit typeProduit, Long id);
	
	void supprimerTypeProduit(Long id);

}
