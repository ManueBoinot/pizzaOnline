package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	public ProduitServiceImpl(ProduitRepository produitRepository) {
		this.produitRepository = produitRepository;

//		enregistrerProduit(new Produit("Margherita", "Base tomate, emmental", 8f, "/img/pizza_margherita.jpg", 1L));
//		enregistrerProduit(
//				new Produit("Regina", "Base tomate, jambon, champignon, emmental", 9f, "/img/pizza_regina.jpg", 1L));
//		enregistrerProduit(new Produit("Pesto verde", "Base pesto vert, jambon cru, mozzarella, emmental", 10f,
//				"/img/pizza_pesto_verde.jpg", 1L));
//		enregistrerProduit(new Produit("Pesto rosso", "Base pesto rouge, jambon cru, mozzarella, emmental", 10f,
//				"/img/pizza_pesto_rosso.jpg", 1L));
//		enregistrerProduit(new Produit("3 Formaggi", "Base tomate, gorgonzola, mozzarella, emmental", 11f,
//				"/img/pizza_3_formaggi.jpg", 1L));
	}

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
	public Optional<Produit> getProduitById(Long id) {
		return produitRepository.findById(id);
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
