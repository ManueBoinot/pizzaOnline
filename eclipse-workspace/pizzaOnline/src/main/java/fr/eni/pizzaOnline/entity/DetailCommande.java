package fr.eni.pizzaOnline.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(DetailCommandeKey.class)
public class DetailCommande {
	
	@Id
	private Long commandeId;
	@Id
	private Long produitId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduit", nullable = false)
	private Produit produit;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCommande", nullable = false)
	private Commande commande;

	private int quantite;

}
