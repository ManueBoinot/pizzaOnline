package fr.eni.pizzaOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.eni.pizzaOnline.entity.Etat;
import fr.eni.pizzaOnline.entity.Produit;
import fr.eni.pizzaOnline.entity.Role;
import fr.eni.pizzaOnline.entity.TypeProduit;
import fr.eni.pizzaOnline.entity.Utilisateur;
import fr.eni.pizzaOnline.repository.EtatRepository;
import fr.eni.pizzaOnline.repository.ProduitRepository;
import fr.eni.pizzaOnline.repository.RoleRepository;
import fr.eni.pizzaOnline.repository.TypeProduitRepository;
import fr.eni.pizzaOnline.repository.UtilisateurRepository;

@Component
public class DataMockBDD {

	@Autowired
	ProduitRepository pr;
	@Autowired
	TypeProduitRepository tpr;
	@Autowired
	EtatRepository er;
	@Autowired
	UtilisateurRepository ur;
	@Autowired
	RoleRepository rr;

	public void initBDDData() {

		er.save(new Etat(1l, "Créée"));
		er.save(new Etat(2l, "Payée"));
		er.save(new Etat(3l, "Préparée"));
		er.save(new Etat(4l, "En livraison"));
		er.save(new Etat(5l, "Livrée"));

		TypeProduit pizza = new TypeProduit(1l, "Pizza");
		TypeProduit boisson = new TypeProduit(2l, "Boisson");
		tpr.save(pizza);
		tpr.save(boisson);

		pr.save(new Produit("Margherita", "Base tomate, emmental", 8f, "/img/pizza_margherita.jpg", pizza));
		pr.save(new Produit("Regina", "Base tomate, jambon, champignon, emmental", 9f, "/img/pizza_regina.jpg", pizza));
		pr.save(new Produit("Pesto verde", "Base pesto vert, jambon cru, mozzarella, emmental", 10f,
				"/img/pizza_pesto_verde.jpg", pizza));
		pr.save(new Produit("Pesto rosso", "Base pesto rouge, jambon cru, mozzarella, emmental", 10f,
				"/img/pizza_pesto_rosso.jpg", pizza));
		pr.save(new Produit("3 Formaggi", "Base tomate, gorgonzola, mozzarella, emmental", 11f,
				"/img/pizza_3_formaggi.jpg", pizza));
		pr.save(new Produit("Coca-cola", "Coca-cola bien frais", 2.5f, "/img/boisson_coca-cola.jpg", boisson));

		Role livreur = new Role(1L, "LIVREUR");
		Role pizzaiolo = new Role(2L, "PIZZAIOLO");
		Role gerant = new Role(3L, "GERANT");
		rr.save(livreur);
		rr.save(pizzaiolo);
		rr.save(gerant);

		ur.save(new Utilisateur("Dupont", "Marie", "marie.dupont@email.com", "mdp", livreur));
		ur.save(new Utilisateur("Bodin", "Bernadette", "bernadette.bodin@email.com", "mdp", pizzaiolo));
		ur.save(new Utilisateur("Loiseau", "Julien", "julien.loiseau@email.com", "mdp", gerant));

	}

}
