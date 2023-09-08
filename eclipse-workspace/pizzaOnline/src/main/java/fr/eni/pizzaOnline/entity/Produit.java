package fr.eni.pizzaOnline.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private TypeProduit typeProduit;

	public Produit(String nom, String description, float prix, String image, TypeProduit typeProduit) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.image = image;
		this.typeProduit = typeProduit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}
		

}
