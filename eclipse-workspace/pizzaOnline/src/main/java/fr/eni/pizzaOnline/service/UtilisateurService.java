package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import fr.eni.pizzaOnline.entity.Utilisateur;

public interface UtilisateurService {
	
	Utilisateur creerUtilisateur(Utilisateur utilisateur);

	List<Utilisateur> consulterUtilisateurs();

	Optional<Utilisateur> getUtilisateurById(Long id);

	Utilisateur modifierUtilisateur(Utilisateur utilisateur, Long id);

	void supprimerUtilisateur(Long id);

}
