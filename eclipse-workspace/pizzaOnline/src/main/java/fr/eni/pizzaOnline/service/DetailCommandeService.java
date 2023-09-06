package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Commande;

public interface DetailCommandeService {

	Commande creerDetailCommande(Commande commande);

	List<Commande> consulterDetailCommandes();

	Optional<Commande> getDetailCommandeById(Long id);

	Commande modifierDetailCommande(Commande commande, Long id);

	void supprimerDetailCommande(Long id);
}
