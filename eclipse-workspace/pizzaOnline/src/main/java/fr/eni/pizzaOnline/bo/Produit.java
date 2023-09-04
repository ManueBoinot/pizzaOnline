package fr.eni.pizzaOnline.bo;

public class Produit {

	private int id;
	private String nom;
	private String description;
	private float prix;

	public Produit() {
	}

	public Produit(int id, String nom, String description, float prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + "]";
	}

}
