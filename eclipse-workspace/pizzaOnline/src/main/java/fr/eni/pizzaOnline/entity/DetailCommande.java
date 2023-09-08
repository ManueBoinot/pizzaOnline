package fr.eni.pizzaOnline.entity;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
	
	@EmbeddedId
	private DetailCommandeKey id = new DetailCommandeKey();

	@ManyToOne
	@MapsId("commandeId")
	private Commande commande;
	
	@ManyToOne
	@MapsId("produitId")
	private Produit produit;

	private int quantite;
	
	public DetailCommande(int quantite, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.commande = commande;
		this.produit = produit;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailCommande other = (DetailCommande) obj;
		return Objects.equals(commande, other.commande) && Objects.equals(id, other.id)
				&& Objects.equals(produit, other.produit);
	}

	@Override
	public String toString() {
		return "DetailCommande [id=" + id + ", commande=" + commande + ", produit=" + produit + ", quantite=" + quantite
				+ "]";
	}

	
}
