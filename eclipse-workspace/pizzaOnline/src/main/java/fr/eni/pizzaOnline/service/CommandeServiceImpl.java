package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.repository.CommandeRepository;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeRepository commandeRepository;

	public CommandeServiceImpl(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}

	@Override
	public Commande creerCommande(Commande commande) {
		// TODO Auto-generated method stub
		return null;
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
