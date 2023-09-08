package fr.eni.pizzaOnline.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateHeureLivraison;
	private LocalDateTime dateHeurePreparation;

	@ManyToOne
	private Etat etat;

	@OneToMany(cascade = CascadeType.ALL)
	private List<DetailCommande> detailsCommande = new ArrayList<>();
	
	public Commande(Etat etat) {
		this.etat = etat;
	}
	
	public void resetCommande() {
		this.id = null;
		this.detailsCommande = new ArrayList<>();
		this.etat = null;
		this.dateHeureLivraison = null;
		this.dateHeurePreparation = null;
	}

}
