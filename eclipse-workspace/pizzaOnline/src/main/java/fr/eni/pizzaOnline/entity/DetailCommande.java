package fr.eni.pizzaOnline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailCommande {

	@Id
	@ManyToOne
	@JoinColumn(name = "idProduit", nullable = false)
	private Produit produit;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCommande", nullable = false)
	private Commande commande;

	private int quantite;

}