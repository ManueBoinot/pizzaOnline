package fr.eni.pizzaOnline.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nom;

	@Column(nullable = false)
	private String prenom;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String motDePasse;

	@ManyToOne
	@JoinColumn(name = "idRole", nullable = false)
	private Role role = new Role();

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Long idRole) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = encoder.encode(motDePasse);
		this.role.setId(idRole);
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Role role) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = encoder.encode(motDePasse);
		this.role = role;
	}

}
