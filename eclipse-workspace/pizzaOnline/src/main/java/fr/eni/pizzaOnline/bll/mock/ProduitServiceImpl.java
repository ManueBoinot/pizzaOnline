package fr.eni.pizzaOnline.bll.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.bll.ProduitService;
import fr.eni.pizzaOnline.bo.Produit;

@Service
public class ProduitServiceImpl implements ProduitService {

	private static int idProduit = 0;
	private static List<Produit> produits = new ArrayList<>();
	
	public ProduitServiceImpl() {
		simuProduits();
	}
	
	public void simuProduits() {
		
		produits.add(new Produit(idProduit++, "Margherita", "Base tomate, emmental"));
		produits.add(new Produit(idProduit++, "Regina", "Base tomate, jambon, champignon, emmental"));
		produits.add(new Produit(idProduit++, "Pesto verde", "Base pesto vert, jambon cru, mozzarella, emmental"));
		produits.add(new Produit(idProduit++, "Pesto rosso", "Base pesto rouge, jambon cru, mozzarella, emmental"));
		produits.add(new Produit(idProduit++, "3 Formaggi", "Base tomate, gorgonzola, mozzarella, emmental"));
	}
	
	
	@Override
	public List<Produit> consulterProduits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void creerProduit(Produit produit) {
		// TODO Auto-generated method stub
		
	}

}
