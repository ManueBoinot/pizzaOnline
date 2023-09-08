package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Commande;

public interface CommandeService {

	Commande creerCommande(Commande commande);

	List<Commande> consulterCommandes();

	Optional<Commande> getCommandeById(Long id);

	Commande modifierCommande(Commande commande, Long id);

}
