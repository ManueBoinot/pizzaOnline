package fr.eni.pizzaOnline.service;

import fr.eni.pizzaOnline.entity.Etat;

public interface EtatService {
	
	Etat creerEtat(Etat etat);
	
	Etat modifierEtat(Etat etat, Long id);

	void supprimerEtat(Long id);

}
