package fr.eni.pizzaOnline.bll.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.bll.ProduitService;
import fr.eni.pizzaOnline.bo.Produit;

@Service
public class ProduitServiceImpl implements ProduitService {

	private static int idProduit = 1;
	private static List<Produit> produits = new ArrayList<>();

	public ProduitServiceImpl() {
		simuProduits();
	}

	public void simuProduits() {

		produits.add(new Produit(idProduit++, "Margherita", "Base tomate, emmental", 8f));
		produits.add(new Produit(idProduit++, "Regina", "Base tomate, jambon, champignon, emmental", 9f));
		produits.add(new Produit(idProduit++, "Pesto verde", "Base pesto vert, jambon cru, mozzarella, emmental", 10f));
		produits.add(new Produit(idProduit++, "Pesto rosso", "Base pesto rouge, jambon cru, mozzarella, emmental", 10f));
		produits.add(new Produit(idProduit++, "3 Formaggi", "Base tomate, gorgonzola, mozzarella, emmental", 11f));
	}

	@Override
	public List<Produit> consulterProduits() {
		return produits;
	}

	@Override
	public void enregistrerProduit(Produit produit) {
		produit.setId(produits.size()+1);
		produits.add(produit);

	}

	@Override
	public Produit getProduitById(int id) {
		for (Produit produit : produits) {
			if (produit.getId() == id)
				return produit;
		}
		return null;
	}

	@Override
	public void modifierProduit(Produit produit) {
		@SuppressWarnings("unused")
		Produit oldProduit = produits.get(produit.getId());
		oldProduit = produit;
	}

	@Override
	public void supprimerProduit(Produit produit) {
		produits.remove(produit);
		produit = null;
	}

}
