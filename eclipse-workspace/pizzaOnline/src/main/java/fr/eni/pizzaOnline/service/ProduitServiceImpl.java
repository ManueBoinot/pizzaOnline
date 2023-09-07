package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> consulterProduits() {
		return produitRepository.findAll();
	}

	@Override
	public Produit enregistrerProduit(Produit produit) {
		if (produit.getImage().isBlank() || produit.getImage().isEmpty()) {
			produit.setImage("/img/pizza_logo.png");
		}
		return produitRepository.save(produit);
	}

	@Override
	public Produit getProduitById(Long id) {
		return produitRepository.findById(id).get();
	}

	@Override
	public Produit modifierProduit(Produit produit, Long id) {
		Produit produitDB = produitRepository.findById(id).get();

		if (Objects.nonNull(produit.getNom()) && !"".equalsIgnoreCase(produit.getNom())) {
			produitDB.setNom(produit.getNom());
		}
		if (Objects.nonNull(produit.getDescription()) && !"".equalsIgnoreCase(produit.getDescription())) {
			produitDB.setDescription(produit.getDescription());
		}
		if (Objects.nonNull(produit.getPrix())) {
			produitDB.setPrix(produit.getPrix());
		}

		return produitRepository.save(produitDB);
	}

	@Override
	public void supprimerProduit(Long id) {
		produitRepository.deleteById(id);
	}

}
