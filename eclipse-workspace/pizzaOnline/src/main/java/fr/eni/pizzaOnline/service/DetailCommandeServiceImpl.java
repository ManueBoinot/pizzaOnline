package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Commande;
import fr.eni.pizzaOnline.repository.DetailCommandeRepository;

@Service
public class DetailCommandeServiceImpl implements DetailCommandeService {
	
	@Autowired
	DetailCommandeRepository detailCommandeRepository;
	
	public DetailCommandeServiceImpl(DetailCommandeRepository detailCommandeRepository) {
		this.detailCommandeRepository = detailCommandeRepository;
	}

	@Override
	public Commande creerDetailCommande(Commande commande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> consulterDetailCommandes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Commande> getDetailCommandeById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Commande modifierDetailCommande(Commande commande, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerDetailCommande(Long id) {
		// TODO Auto-generated method stub
		
	}

}
