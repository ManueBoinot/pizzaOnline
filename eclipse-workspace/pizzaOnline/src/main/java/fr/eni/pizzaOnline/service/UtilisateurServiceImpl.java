package fr.eni.pizzaOnline.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.eni.pizzaOnline.entity.Utilisateur;
import fr.eni.pizzaOnline.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;


	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public Utilisateur creerUtilisateur(Utilisateur utilisateur) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		utilisateur.setMotDePasse(encoder.encode(utilisateur.getMotDePasse()));
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public List<Utilisateur> consulterUtilisateurs() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Optional<Utilisateur> getUtilisateurById(Long id) {
		return utilisateurRepository.findById(id);
	}

	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur, Long id) {
		Utilisateur utilisateurDB = utilisateurRepository.findById(id).get();

		if (Objects.nonNull(utilisateur.getNom()) && !"".equalsIgnoreCase(utilisateur.getNom())) {
			utilisateurDB.setNom(utilisateur.getNom());
		}
		if (Objects.nonNull(utilisateur.getPrenom()) && !"".equalsIgnoreCase(utilisateur.getPrenom())) {
			utilisateurDB.setPrenom(utilisateur.getPrenom());
		}
		if (Objects.nonNull(utilisateur.getRole())) {
			utilisateurDB.setRole(utilisateur.getRole());
		}
		if (Objects.nonNull(utilisateur.getEmail()) && !"".equalsIgnoreCase(utilisateur.getEmail())) {
			utilisateurDB.setEmail(utilisateur.getEmail());
		}
		return utilisateurRepository.save(utilisateurDB);
	}

	@Override
	public void supprimerUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
	}

	@Override
	public Utilisateur findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}
}