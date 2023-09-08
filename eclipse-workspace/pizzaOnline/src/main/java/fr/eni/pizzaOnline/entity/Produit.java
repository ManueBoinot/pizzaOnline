package fr.eni.pizzaOnline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nom;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private float prix;

	@Column(columnDefinition = "varchar(255) default '/img/pizza_logo.png'")
	private String image;

	@ManyToOne
	@JoinColumn(name = "idType", nullable = false)
	private TypeProduit typeProduit = new TypeProduit();

	public Produit(String nom, String description, float prix, String image, Long typeProduitId) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.typeProduit.setId(typeProduitId);
	}

	public Produit(String nom, String description, float prix, String image, TypeProduit typeProduit) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.typeProduit = typeProduit;
	}
}
